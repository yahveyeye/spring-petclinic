/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zymb.gxyhxx.reservation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.core.style.ToStringCreator;

/**
 * Simple JavaBean domain object representing an reservation.
 *
 * @author yuan lin
 */
@Entity
@Table(name = "reservations")
public class Reservation extends Person {
    
	//手机号码
	@Column(name = "phone")
    @Pattern(regexp="^1[3-8]+\\d{9}",message="手机号码不合法")
    private String phone;

	//电子邮箱
    @Column(name = "email")
    @NotEmpty
    @Email
    private String email;

    //qq号
    @Column(name = "qq")
    @NotEmpty
    @Length(min=4, max=13)
    private String qq;


    public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}



	public String getQq() {
		return qq;
	}




	public void setQq(String qq) {
		this.qq = qq;
	}

	@Override
    public String toString() {
        return new ToStringCreator(this)

                .append("id", this.getId())
                .append("new", this.isNew())
                .append("lastName", this.getPersonName())
                .append("firstName", this.getIdCardNo())
                .append("address", this.phone)
                .append("city", this.email)
                .append("qq", this.qq)
                .toString();
    }
	
	
}
