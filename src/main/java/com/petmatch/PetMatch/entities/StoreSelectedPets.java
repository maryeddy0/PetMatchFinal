package com.petmatch.PetMatch.entities;

	public class StoreSelectedPets {
		private String photos;
		private String name;
		private String age;
		private String gender;
		private String description;
		
		
		public StoreSelectedPets() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		public StoreSelectedPets(String name, String age, String gender) {
			super();
			this.name = name;
			this.age = age;
			this.gender = gender;
		}

		public StoreSelectedPets(String photos, String name, String age, String gender, String description) {
			super();
			this.photos = photos;
			this.name = name;
			this.age = age;
			this.gender = gender;
			this.description = description;
		}
		public String getPhotos() {
			return photos;
		}
		public void setphotos(String photos) {
			this.photos = photos;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}

		@Override
		public String toString() {
			return "StoreSelectedPets [name=" + name + ", age=" + age + ", gender=" + gender + "]";
		}
		
		
		
		

}
