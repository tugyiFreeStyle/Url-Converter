package com.trendyol.convertlink.application.services;

import com.trendyol.convertlink.application.dtos.*;
import com.trendyol.convertlink.application.exceptions.InvalidRequestException;
import com.trendyol.convertlink.domain.ShortLinkAlreadyExistException;

public interface LinkAppService {

    GenerateShortLinkResponseDto generate(GenerateShortLinkRequestDto requestDto) throws ShortLinkAlreadyExistException;

    DeepLinkFromWebUrlResponseDto convert(DeepLinkFromWebUrlRequestDto requestDto);

    WebUrlFromDeepLinkResponseDto convert(WebUrlFromDeepLinkRequestDto requestDto);

    ServeShortLinkResponseDto serve(ServeShortLinkRequestDto request) throws InvalidRequestException;
}
