package com.ikea.oibmb.pojo;

import java.util.List;

public class Data {

	private List<Person> persons;
	private Long totalRecords;
	private Long totalPages;
	private Long recordsFetched;
	private Long delta;

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public Long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(Long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public Long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}

	public Long getRecordsFetched() {
		return recordsFetched;
	}

	public void setRecordsFetched(Long recordsFetched) {
		this.recordsFetched = recordsFetched;
	}

	public Long getDelta() {
		return delta;
	}

	public void setDelta(Long delta) {
		this.delta = delta;
	}

}

