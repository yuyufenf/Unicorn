package com.gumdan.unicorn.entity;

import java.util.Date;

public class Person extends BaseEntity<Person>{

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitor_person.PERSON_NAME
     *
     * @mbg.generated
     */
    private String personName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitor_person.PERSON_CODE
     *
     * @mbg.generated
     */
    private String personCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitor_person.LIST_TYPE
     *
     * @mbg.generated
     */
    private String listType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitor_person.SEX
     *
     * @mbg.generated
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitor_person.BIRTHDAY
     *
     * @mbg.generated
     */
    private Date birthday;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitor_person.ADDERS
     *
     * @mbg.generated
     */
    private String adders;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitor_person.PHONE
     *
     * @mbg.generated
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitor_person.PHONE_TWO
     *
     * @mbg.generated
     */
    private String phoneTwo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitor_person.PLATE_NUMBER
     *
     * @mbg.generated
     */
    private String plateNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitor_person.FACE_IMG
     *
     * @mbg.generated
     */
    private String faceImg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitor_person.FACE_ID
     *
     * @mbg.generated
     */
    private String faceId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitor_person.DEPT_CODE
     *
     * @mbg.generated
     */
    private String deptCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitor_person.DEPT_NAME
     *
     * @mbg.generated
     */
    private String deptName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column visitor_person.VALIDDATE
     *
     * @mbg.generated
     */
    private Date validDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitor_person.PERSON_NAME
     *
     * @return the value of visitor_person.PERSON_NAME
     *
     * @mbg.generated
     */
    public String getPersonName() {
        return personName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitor_person.PERSON_NAME
     *
     * @param personName the value for visitor_person.PERSON_NAME
     *
     * @mbg.generated
     */
    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitor_person.PERSON_CODE
     *
     * @return the value of visitor_person.PERSON_CODE
     *
     * @mbg.generated
     */
    public String getPersonCode() {
        return personCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitor_person.PERSON_CODE
     *
     * @param personCode the value for visitor_person.PERSON_CODE
     *
     * @mbg.generated
     */
    public void setPersonCode(String personCode) {
        this.personCode = personCode == null ? null : personCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitor_person.LIST_TYPE
     *
     * @return the value of visitor_person.LIST_TYPE
     *
     * @mbg.generated
     */
    public String getListType() {
        return listType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitor_person.LIST_TYPE
     *
     * @param listType the value for visitor_person.LIST_TYPE
     *
     * @mbg.generated
     */
    public void setListType(String listType) {
        this.listType = listType == null ? null : listType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitor_person.SEX
     *
     * @return the value of visitor_person.SEX
     *
     * @mbg.generated
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitor_person.SEX
     *
     * @param sex the value for visitor_person.SEX
     *
     * @mbg.generated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitor_person.BIRTHDAY
     *
     * @return the value of visitor_person.BIRTHDAY
     *
     * @mbg.generated
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitor_person.BIRTHDAY
     *
     * @param birthday the value for visitor_person.BIRTHDAY
     *
     * @mbg.generated
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitor_person.ADDERS
     *
     * @return the value of visitor_person.ADDERS
     *
     * @mbg.generated
     */
    public String getAdders() {
        return adders;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitor_person.ADDERS
     *
     * @param adders the value for visitor_person.ADDERS
     *
     * @mbg.generated
     */
    public void setAdders(String adders) {
        this.adders = adders == null ? null : adders.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitor_person.PHONE
     *
     * @return the value of visitor_person.PHONE
     *
     * @mbg.generated
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitor_person.PHONE
     *
     * @param phone the value for visitor_person.PHONE
     *
     * @mbg.generated
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitor_person.PHONE_TWO
     *
     * @return the value of visitor_person.PHONE_TWO
     *
     * @mbg.generated
     */
    public String getPhoneTwo() {
        return phoneTwo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitor_person.PHONE_TWO
     *
     * @param phoneTwo the value for visitor_person.PHONE_TWO
     *
     * @mbg.generated
     */
    public void setPhoneTwo(String phoneTwo) {
        this.phoneTwo = phoneTwo == null ? null : phoneTwo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitor_person.PLATE_NUMBER
     *
     * @return the value of visitor_person.PLATE_NUMBER
     *
     * @mbg.generated
     */
    public String getPlateNumber() {
        return plateNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitor_person.PLATE_NUMBER
     *
     * @param plateNumber the value for visitor_person.PLATE_NUMBER
     *
     * @mbg.generated
     */
    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber == null ? null : plateNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitor_person.FACE_IMG
     *
     * @return the value of visitor_person.FACE_IMG
     *
     * @mbg.generated
     */
    public String getFaceImg() {
        return faceImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitor_person.FACE_IMG
     *
     * @param faceImg the value for visitor_person.FACE_IMG
     *
     * @mbg.generated
     */
    public void setFaceImg(String faceImg) {
        this.faceImg = faceImg == null ? null : faceImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitor_person.FACE_ID
     *
     * @return the value of visitor_person.FACE_ID
     *
     * @mbg.generated
     */
    public String getFaceId() {
        return faceId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitor_person.FACE_ID
     *
     * @param faceId the value for visitor_person.FACE_ID
     *
     * @mbg.generated
     */
    public void setFaceId(String faceId) {
        this.faceId = faceId == null ? null : faceId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitor_person.DEPT_CODE
     *
     * @return the value of visitor_person.DEPT_CODE
     *
     * @mbg.generated
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitor_person.DEPT_CODE
     *
     * @param deptCode the value for visitor_person.DEPT_CODE
     *
     * @mbg.generated
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode == null ? null : deptCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitor_person.DEPT_NAME
     *
     * @return the value of visitor_person.DEPT_NAME
     *
     * @mbg.generated
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitor_person.DEPT_NAME
     *
     * @param deptName the value for visitor_person.DEPT_NAME
     *
     * @mbg.generated
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column visitor_person.VALIDDATE
     *
     * @return the value of visitor_person.VALIDDATE
     *
     * @mbg.generated
     */
    public Date getValidDate() {
        return validDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column visitor_person.VALIDDATE
     *
     * @param validDate the value for visitor_person.VALIDDATE
     *     * @mbg.generated
     */
    public void setValidDate(Date validDate) {
        this.validDate = validDate;
    }

    public Person(){
        this.personName = "呵呵";
    }

    @Override
    public String toString() {
        return  super.toString() +
                "personName='" + personName + '\'' + "\n" +
                "personCode='" + personCode + '\'' + "\n" +
                "listType='" + listType + '\'' + "\n" +
                "sex='" + sex + '\'' + "\n" +
                "birthday='" + birthday + '\'' + "\n" +
                "adders='" + adders + '\'' + "\n" +
                "phone='" + phone + '\'' + "\n" +
                "phoneTwo='" + phoneTwo + '\'' + "\n" +
                "plateNumber='" + plateNumber + '\'' + "\n" +
                "faceImg='" + faceImg + '\'' + "\n" +
                "faceId='" + faceId + '\'' + "\n" +
                "validDate='" + validDate + '\'';
    }
}