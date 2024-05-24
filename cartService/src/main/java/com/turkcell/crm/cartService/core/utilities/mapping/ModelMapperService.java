package com.turkcell.crm.cartService.core.utilities.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
    ModelMapper forRequestStrict();
    ModelMapper forUpdate();
}
