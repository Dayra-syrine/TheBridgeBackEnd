package com.exp.demo.model;

import javax.persistence.Embeddable;

@Embeddable
public class RegistrationPK {
	
	 private Long cours;

	    private Long user;
	     


		public Long getCours() {
			return cours;
		}

		public void setCours(Long cours) {
			this.cours = cours;
		}

		public Long getUser() {
			return user;
		}

		public void setUser(Long user) {
			this.user = user;
		}

		@Override
		public boolean equals(Object arg0) {
			// TODO Auto-generated method stub
			return super.equals(arg0);
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}

}
