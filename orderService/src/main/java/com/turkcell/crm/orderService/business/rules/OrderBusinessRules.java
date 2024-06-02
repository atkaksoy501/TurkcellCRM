package com.turkcell.crm.orderService.business.rules;

import com.turkcell.crm.core.core.exceptions.types.BusinessException;
import com.turkcell.crm.orderService.business.messages.Messages;
import com.turkcell.crm.orderService.core.business.abstracts.MessageService;
import com.turkcell.crm.orderService.dataAccess.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class OrderBusinessRules {

    private final OrderRepository orderRepository;
    private final MessageService messageService;

    public void orderMustExist(int id) {
        if (!orderRepository.existsById(id)) {
            throw new BusinessException(messageService.getMessage(Messages.OrderErrors.ORDER_NOT_FOUND));
        }
    }

}
