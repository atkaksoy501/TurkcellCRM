package com.turkcell.crm.catalogService.catalogService.business.rules;

import com.turkcell.crm.catalogService.catalogService.core.business.abstracts.MessageService;
import com.turkcell.crm.catalogService.catalogService.dataAccess.abstracts.CatalogRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CatalogBusinessRules {

    private final CatalogRepository catalogRepository;
    private final MessageService messageService;

}
