package part2.model;

public class RollingStoneAlbum {

	private String year;
	private String album;
	private String artist;
	private String genre;
	private String subgenre;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getSubgenre() {
		return subgenre;
	}

	public void setSubgenre(String subgenre) {
		this.subgenre = subgenre;
	}

	@Override
	public String toString() {
		return "RollingStoneAlbum [year=" + year + ", album=" + album + ", artist=" + artist + ", genre=" + genre
				+ ", subgenre=" + subgenre + "]";
	}

}
