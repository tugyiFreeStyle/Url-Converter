package com.trendyol.convertlink.domain.shared;


@ExceptionDetail(responseCode = 404, errorMessage = "Entity could not be found")
public class EntityNotFoundException extends DomainException {
}
