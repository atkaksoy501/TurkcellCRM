package com.turkcell.crm.catalogService.catalogService.core.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {
    ModelMapper forResponse();
    ModelMapper forRequest();
    ModelMapper forRequestStrict();
    ModelMapper forUpdate();
}
