package org.mvpsuite.problem.builder;

import lombok.RequiredArgsConstructor;
import org.mvpsuite.problem.ProblemDetail;
import org.mvpsuite.problem.member.Detail;
import org.mvpsuite.problem.member.Status;
import org.mvpsuite.problem.member.Title;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.util.UUID;

@RequiredArgsConstructor
public class ProblemDetailBuilder {
    private final Throwable throwable;

    public ProblemDetail build() {
        return ProblemDetail
                .builder()
                .title(buildTitle())
                .type(buildType())
                .detail(buildDetailMessage())
                .status(buildStatus())
                .instance(buildInstance())
                .build();
    }

    private URI buildType() {
        return URI.create("https://api.mvpsuite.org/" + javadocName(throwable.getClass()));
    }

    private static String javadocName(Class<?> type) {
        return type.getName()
                .replace('.', '/')
                .replace('$', '.');
    }

    private String buildTitle() {
        Title title = throwable.getClass().getAnnotation(Title.class);

        if (title != null) {
            return title.value();
        }

        return camelToWords(throwable.getClass().getSimpleName());
    }

    private static String camelToWords(String input) {
        return String.join(" ", input.split("(?=\\p{javaUpperCase})"));
    }

    private String buildDetailMessage() {
        Detail detail = throwable.getClass().getAnnotation(Detail.class);

        if (detail != null) {
            return detail.value();
        }

        return throwable.getMessage();
    }

    private int buildStatus() {
        Status status = throwable.getClass().getAnnotation(Status.class);

        if (status != null) {
            return status.value().value();
        }

        return HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    private URI buildInstance() {
        return URI.create("urn:uuid:" + UUID.randomUUID());
    }
}