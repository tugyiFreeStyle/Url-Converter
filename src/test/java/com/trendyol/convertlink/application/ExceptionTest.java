package com.trendyol.convertlink.application;

import com.trendyol.convertlink.domain.shared.EntityNotFoundException;
import com.trendyol.convertlink.domain.shared.ExceptionDetail;
import org.junit.jupiter.api.Test;
import org.springframework.core.annotation.AnnotationUtils;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class ExceptionTest {

    @Test
    public void should_return_not_found() {
        EntityNotFoundException ex = new EntityNotFoundException();

        ExceptionDetail exDetail = AnnotationUtils.findAnnotation(ex.getClass(), ExceptionDetail.class);

        assertThat(exDetail.responseCode()).isEqualTo(404);
    }
}
