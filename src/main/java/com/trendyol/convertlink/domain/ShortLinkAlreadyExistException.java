package com.trendyol.convertlink.domain;

import com.trendyol.convertlink.domain.shared.DomainException;
import com.trendyol.convertlink.domain.shared.ExceptionDetail;

@ExceptionDetail(errorMessage = "ShortLink already exist")
public class ShortLinkAlreadyExistException extends DomainException {
}
