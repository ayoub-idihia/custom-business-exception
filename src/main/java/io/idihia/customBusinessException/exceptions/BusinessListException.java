package io.idihia.customBusinessException.exceptions;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@Getter
@JsonAutoDetect(fieldVisibility = NONE, getterVisibility = NONE)
public class BusinessListException extends RuntimeException {

    private final List<BusinessException> exceptions = new ArrayList<>();

    public BusinessListException() {
        super("BusinessListException");
    }

    public BusinessListException(final BusinessException exception) {
        this();
        this.exceptions.add(exception);
    }

    public BusinessListException(final List<BusinessException> exceptions) {
        this();
        this.exceptions.addAll(exceptions);
    }

    /**
     * Adds a single exception to the list
     * Ajout d'une exception à la liste
     *
     * @param exception The exception to add
     *                  L'exception à ajouter
     * @return The instance of the class to allow chained calls
     * L'instance de la class afin de permettre les appels chaînés
     */
    public BusinessListException addException(final BusinessException exception) {
        this.exceptions.add(exception);
        return this;
    }

    /**
     * Adds a list of exceptions to the list
     * Ajout d'une liste d'exceptions à la liste
     *
     * @param exceptions The list of exceptions to add
     *                   La liste d'exceptions à ajouter
     * @return The instance of the class to allow chained calls
     * L'instance de la class afin de permettre les appels chaînés
     */
    public BusinessListException addExceptions(final List<BusinessException> exceptions) {
        this.exceptions.addAll(exceptions);
        return this;
    }

    /**
     * Concatenates all exception messages into a single {@link String}, separated by ", "
     * Concaténation des messages de toutes les exceptions avec le délimiteur ", " vers une {@link String}
     *
     * @return A {@link String}
     * Une {@link String}
     */
    @Override
    public String toString() {
        return exceptions.stream().map(BusinessException::toString).collect(Collectors.joining(", "));
    }
}

