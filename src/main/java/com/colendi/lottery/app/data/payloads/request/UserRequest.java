package com.colendi.lottery.app.data.payloads.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import jakarta.persistence.Column;

public class UserRequest {
        @NotBlank
        @Column(nullable = false)
        private String firstName;
        @NotBlank
        @Column(nullable = false)
        private String lastName;
        @Email
        private String email;

        public String getFirstName() {
                return firstName;
        }

        public void setFirstName(String firstName) {
                this.firstName = firstName;
        }

        public String getLastName() {
                return lastName;
        }

        public void setLastName(String lastName) {
                this.lastName = lastName;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }
}
