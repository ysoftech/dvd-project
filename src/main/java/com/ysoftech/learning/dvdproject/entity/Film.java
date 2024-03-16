package com.ysoftech.learning.dvdproject.entity;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Component // Marked it as Spring Bean to support converter for Enum
public class Film extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "film_id")
    private Integer id;

    private String title;

    private String description;

    @Column(name = "release_year")
    private Integer releaseYear;

    @Column(name = "rental_duration")
    private Short rentalDuration;

    @Column(name = "rental_rate")
    private Double rentalRate;

    private Short length;

    @Column(name = "replacement_cost")
    private Double replacementCost;

    //@Enumerated(EnumType.STRING)
    @Convert(converter = MPAA_RATINGConverter.class)
    private MPAA_RATING rating;

    @ManyToMany
    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "film_id"), inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToMany
    @JoinTable(name = "film_category", joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories = new ArrayList<>();

    @OneToMany(mappedBy = "film")
    private List<Inventory> inventories = new ArrayList<>();

    protected Film() {}

    public Film(String title, Integer releaseYear, Short length, MPAA_RATING rating) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.length = length;
        this.rating = rating;
    }

    public Integer getId() {
        return id;
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

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Short getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public Double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(Double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public Double getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(Double replacementCost) {
        this.replacementCost = replacementCost;
    }

    public MPAA_RATING getRating() {
        return rating;
    }

    public void setRating(MPAA_RATING rating) {
        this.rating = rating;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addActors(Actor actor) {
        this.getActors().add(actor);
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category category) {
        this.getCategories().add(category);
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void addInventory(Inventory inventory) {
        this.getInventories().add(inventory);
    }

    public enum MPAA_RATING {
        G("G"),
        PG("PG"),
        PG_13("PG-13"),
        R("R"),
        NC_17("NC-17");

        private String code;
        private static final String G_CODE = "G";
        private static final String PG_CODE = "PG";
        private static final String PG13_CODE = "PG-13";
        private static final String R_CODE = "R";
        private static final String NC17_CODE = "NC-17";

        MPAA_RATING(String code) {
            this.code = code;
        }
         public String getCode() {
             return code;
         }

         public static MPAA_RATING fromCode(String code) {
            if(code == null || code.isEmpty())
                throw new IllegalArgumentException("Code value for MPAA_Enum Type can not be null or empty");

            String lowerCaseCode = code.toUpperCase();
            switch (lowerCaseCode) {
                case MPAA_RATING.G_CODE:
                    return MPAA_RATING.G;
                case MPAA_RATING.PG_CODE:
                    return MPAA_RATING.PG;
                case MPAA_RATING.PG13_CODE:
                    return MPAA_RATING.PG_13;
                case MPAA_RATING.R_CODE:
                    return MPAA_RATING.R;
                case MPAA_RATING.NC17_CODE:
                    return MPAA_RATING.NC_17;
                default:
                    throw new IllegalArgumentException(String.format("Invalid value of code is passed. Value must be any of " +
                            "(%s, %s, %s, %s, %s)",
                            MPAA_RATING.G_CODE,
                            MPAA_RATING.PG_CODE,
                            MPAA_RATING.PG13_CODE,
                            MPAA_RATING.R_CODE,
                            MPAA_RATING.NC17_CODE ));
            }
         }
     }

     public class MPAA_RATINGConverter implements AttributeConverter<MPAA_RATING, String> {

         @Override
         public String convertToDatabaseColumn(MPAA_RATING mpaa_rating) {
             return mpaa_rating == null ? null : mpaa_rating.getCode();
         }

         @Override
         public MPAA_RATING convertToEntityAttribute(String code) {
             return (code == null || code.isEmpty()) ? null : MPAA_RATING.fromCode(code);
         }
     }
}