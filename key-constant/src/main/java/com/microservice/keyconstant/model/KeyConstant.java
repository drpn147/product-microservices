package com.microservice.keyconstant.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "key_constant")
public class KeyConstant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "key_id")
	private int keyId;
	@Column(name = "key_name")
	private String keyName;
	@Column(name = "current_key_count")
	private int currentKeyCount;

	public KeyConstant() {
		super();
	}

	public KeyConstant(int keyId, String keyName, int currentKeyCount) {
		super();
		this.keyId = keyId;
		this.keyName = keyName;
		this.currentKeyCount = currentKeyCount;
	}

	public int getKeyId() {
		return keyId;
	}

	public void setKeyId(int keyId) {
		this.keyId = keyId;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public int getCurrentKeyCount() {
		return currentKeyCount;
	}

	public void setCurrentKeyCount(int currentKeyCount) {
		this.currentKeyCount = currentKeyCount;
	}

}
