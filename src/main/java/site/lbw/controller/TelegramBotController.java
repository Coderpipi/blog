package site.lbw.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import site.lbw.util.telegram.TelegramBotMsgHandler;
import site.lbw.config.properties.TelegramProperties;
import site.lbw.constant.CommentConstants;
import site.lbw.model.dto.TgMessage;

@Slf4j
@ConditionalOnProperty(name = "comment.notify.channel", havingValue = CommentConstants.TELEGRAM)
@RestController
public class TelegramBotController {
	@Autowired
	private TelegramBotMsgHandler msgHandler;
	@Autowired
	private TelegramProperties telegramProperties;

	/**
	 * webhook方式监听bot收到的新消息
	 *
	 * @param message 新消息
	 */
	@PostMapping("/tg/${tg.bot.token}")
	public void getUpdate(@RequestBody TgMessage message) {
		log.info("Telegram bot receive message: {}", message);
		//判断消息是否是自己发出的
		if (message != null && message.getMessage() != null && message.getMessage().getChat() != null
				&& telegramProperties.getChatId().equals(message.getMessage().getChat().getId())) {
			//判断是不是正常的文本消息
			if (message.getMessage().getText() != null) {
				//处理消息
				msgHandler.processCommand(message.getMessage().getText());
			}
		}
	}
}
