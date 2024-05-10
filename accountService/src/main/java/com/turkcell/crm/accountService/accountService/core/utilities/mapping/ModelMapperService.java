package com.turkcell.crm.accountService.accountService.core.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
    ModelMapper forUpdate();
}
