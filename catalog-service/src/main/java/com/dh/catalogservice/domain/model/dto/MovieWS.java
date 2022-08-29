package com.dh.catalogservice.domain.model.dto;

import lombok.Data;

@Data
public class MovieWS {

    private Integer id;
    private String name;
    private String genre;
    private String urlStream;

    @Override
    public String toString() {
        return "MovieWS{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", genre='" + genre + '\'' +
                ", urlStream='" + urlStream + '\'' +
                '}';
    }
}
