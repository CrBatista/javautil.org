package org.javautil.mp3;

// Generated Jan 14, 2011 1:36:15 AM by Hibernate Tools 3.2.2.GA

/**
 * Mp3 generated by hbm2java
 */
public class Mp3 implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer mp3Id;
	private String fileName;
	private Integer bitRate;
	private String albumTitle;
	private String songTitle;
	private String author;
	private String artistName;
	private String genre;
	private String songComment;
	private String track;
	private String yearReleased;
	private Integer artistId;

	public Mp3() {
	}

	public Mp3(final String fileName) {
		this.fileName = fileName;
	}

	public Mp3(final String fileName, final Integer bitRate,
			final String albumTitle, final String songTitle,
			final String author, final String artistName, final String genre,
			final String songComment, final String track,
			final String yearReleased, final Integer artistId) {
		this.fileName = fileName;
		this.bitRate = bitRate;
		this.albumTitle = albumTitle;
		this.songTitle = songTitle;
		this.author = author;
		this.artistName = artistName;
		this.genre = genre;
		this.songComment = songComment;
		this.track = track;
		this.yearReleased = yearReleased;
		this.artistId = artistId;
	}

	public Integer getMp3Id() {
		return this.mp3Id;
	}

	public void setMp3Id(final Integer mp3Id) {
		this.mp3Id = mp3Id;
	}

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(final String fileName) {
		this.fileName = fileName;
	}

	public Integer getBitRate() {
		return this.bitRate;
	}

	public void setBitRate(final Integer bitRate) {
		this.bitRate = bitRate;
	}

	public String getAlbumTitle() {
		return this.albumTitle;
	}

	public void setAlbumTitle(final String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getSongTitle() {
		return this.songTitle;
	}

	public void setSongTitle(final String songTitle) {
		this.songTitle = songTitle;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public String getArtistName() {
		return this.artistName;
	}

	public void setArtistName(final String artistName) {
		this.artistName = artistName;
	}

	public String getGenre() {
		return this.genre;
	}

	public void setGenre(final String genre) {
		this.genre = genre;
	}

	public String getSongComment() {
		return this.songComment;
	}

	public void setSongComment(final String songComment) {
		this.songComment = songComment;
	}

	public String getTrack() {
		return this.track;
	}

	public void setTrack(final String track) {
		this.track = track;
	}

	public String getYearReleased() {
		return this.yearReleased;
	}

	public void setYearReleased(final String yearReleased) {
		this.yearReleased = yearReleased;
	}

	public Integer getArtistId() {
		return this.artistId;
	}

	public void setArtistId(final Integer artistId) {
		this.artistId = artistId;
	}

}