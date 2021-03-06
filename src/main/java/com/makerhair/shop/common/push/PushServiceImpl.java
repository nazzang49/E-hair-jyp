package com.makerhair.shop.common.push;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.makehair.shop.common.constants.PushVo;

@Service
public class PushServiceImpl implements PushService {

	/**
	 * 메시지 전송 template
	 */
	private final transient SimpMessagingTemplate template;
	
	/**
	 * 생성자
	 * @param template
	 */
	@Autowired
	public PushServiceImpl(final SimpMessagingTemplate template) {
		this.template = template;
	}

	@Override
	public void push(final PushVo pushVo) {
		template.convertAndSend("/topic/event", pushVo);
	}

	@Override
	public void pushTo(final String user, final PushVo pushVo) {
		template.convertAndSendToUser(user, "/event", pushVo);
	}

}
