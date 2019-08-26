package com.rakuten.internship.entity;

import javax.persistence.*;

@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long number;
    private String text;
    private String sourceLanguage;
    private String targetLanguage;
    private String translatedText;

    protected Todo() {}

	/**
	 * @return the number
	 */
	public Long getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Long number) {
		this.number = number;
	}

	/**
	 * @return the title
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the title to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the description
	 */
	public String getTranslatedText() {
		return translatedText;
	}

	/**
	 * @param translatedText the description to set
	 */
	public void setDescription(String translatedText) {
		this.translatedText = translatedText;
	}

	/**
	 * @return the sourceLanguage
	 */
	public String getSourceLanguage() {
		return sourceLanguage;
	}

	/**
	 * @param sourceLanguage the sourceLanguage to set
	 */
	public void setSourceLanguage(String sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}

	/**
	 * @return the targetLanguage
	 */
	public String getTargetLanguage() {
		return targetLanguage;
	}

	/**
	 * @param targetLanguage the targetLanguage to set
	 */
	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}

	/**
	 * @param translatedText the translatedText to set
	 */
	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}
}