package com.victorbicego.databasecrud;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {
    private int id;
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private int pages;

}
