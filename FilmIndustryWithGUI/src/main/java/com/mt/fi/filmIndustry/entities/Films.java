package com.mt.fi.filmIndustry.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Films 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int filmId;
    @Column(name="FilmName")
	private String filmName;
	private float boxOfficeCollection;
	private float rating;
	
	@ManyToMany
    @JoinTable(name="Directors_Assigned")
	private List<Director> directedBy;

	public Films() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Films(int filmId, String filmName, float boxOfficeCollection, float rating, List<Director> directedBy) {
		super();
		this.filmId = filmId;
		this.filmName = filmName;
		this.boxOfficeCollection = boxOfficeCollection;
		this.rating = rating;
		this.directedBy = directedBy;
	}

	public int getFilmId() {
		return filmId;
	}

	
	
	public String getFilmName() {
		return filmName;
	}

	public void setFilmName(String filmName) {
		this.filmName = filmName;
	}

	public float getBoxOfficeCollection() {
		return boxOfficeCollection;
	}

	public void setBoxOfficeCollection(float boxOfficeCollection) {
		this.boxOfficeCollection = boxOfficeCollection;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public List<Director> getDirectedBy() {
		return directedBy;
	}

	public void setDirectedBy(List<Director> directedBy) {
		this.directedBy = directedBy;
	}

	@Override
	public String toString() {
		String direct = "";
		for (Director director : directedBy) {
			direct += "\n" + director;
		}
		return "\nFilm ID=" + filmId + ", Movie Name='" + filmName + '\'' + "\nBox Office Collections="
				+ boxOfficeCollection + ", Ratings=" + rating + "\n\nDirectors of this movie:" + direct + "\n";

	}
}