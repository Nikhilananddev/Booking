package com.booking.Booking.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class Response<T> {

    @NotNull(message = "response cannot null")
    List<T> list = new ArrayList<T>();
}
