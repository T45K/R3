package com.rakuten.internship.entity;

import java.io.Serializable;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class TranslateLanguages implements Serializable {

    private static final long serialVersionUID = 1L;

	private String sourceLanguage = "ja";
    private String targetLanguage = "en";

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
}
