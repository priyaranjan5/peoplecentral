package com.hutech.payrollapp.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "education")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long courseId;
	private String qualificationType;
	private String courseName;
	private String courseType;
	private String stream;
	private String courseStratDate;
	private String courseEndDate;
	private String collegeName;
	private String universityName;

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public String getQualificationType() {
		return qualificationType;
	}

	public void setQualificationType(String qualificationType) {
		this.qualificationType = qualificationType;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getCourseStratDate() {
		return courseStratDate;
	}

	public void setCourseStratDate(String courseStratDate) {
		this.courseStratDate = courseStratDate;
	}

	public String getCourseEndDate() {
		return courseEndDate;
	}

	public void setCourseEndDate(String courseEndDate) {
		this.courseEndDate = courseEndDate;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	public Education(Long courseId, String qualificationType, String courseName, String courseType, String stream,
			String courseStratDate, String courseEndDate, String collegeName, String universityName) {
		super();
		this.courseId = courseId;
		this.qualificationType = qualificationType;
		this.courseName = courseName;
		this.courseType = courseType;
		this.stream = stream;
		this.courseStratDate = courseStratDate;
		this.courseEndDate = courseEndDate;
		this.collegeName = collegeName;
		this.universityName = universityName;
	}

	public Education() {
		super();
	}

}
