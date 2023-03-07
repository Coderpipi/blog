package site.lbw.util.upload.channel;

import site.lbw.constant.UploadConstants;
import site.lbw.util.common.SpringContextUtils;

public class ChannelFactory {
	/**
	 * 创建文件上传方式
	 *
	 * @param channelName 方式名称
	 * @return
	 */
	public static FileUploadChannel getChannel(String channelName) {
		if (UploadConstants.LOCAL.equalsIgnoreCase(channelName)) {
			return SpringContextUtils.getBean("localChannel", FileUploadChannel.class);
		} else if (UploadConstants.GITHUB.equalsIgnoreCase(channelName)) {
			return SpringContextUtils.getBean("githubChannel", FileUploadChannel.class);
		}
		throw new RuntimeException("Unsupported value in [application.properties]: [upload.channel]");
	}
}
