package be.vdab.spring.mvc;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min=2,max=100, message="Number of characters needs to be between 2 and 100.")
    private String title;

    @NotNull
    @Size(min=2, message="At least 2 characters needed.")
    @Column(length = 1000)
    private String description;

    @NotNull
    @Size(min=4, max=4)
    @Max(2020)
    @Min(1850)
    private String releaseYear;

    @NotNull

    @Max(value=500, message="Duration cannot exceed 500 minutes.")
    @Min(value=1, message="Duration cannot be less than 1 minute.")
    private int length;

    public Film() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    @Override
    public String toString() {
        return id + ".\t" +title+ "\t" + description+ "\t"  + releaseYear+ "\t"  + length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
