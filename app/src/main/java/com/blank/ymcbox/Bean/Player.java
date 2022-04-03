package com.blank.ymcbox.Bean;
import java.util.List;

public class Player {
    
	private String name;

    private String id;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

	public class PlayerProperties{
		private String id;

		private String name;

		private List<Properties> properties;

		public void setId(String id) {
			this.id = id;
		}

		public String getId() {
			return id;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setProperties(List<Properties> properties) {
			this.properties = properties;
		}

		public List<Properties> getProperties() {
			return properties;
		}
		public class Properties {

			private String name;

			private String value;

			public void setName(String name) {
				this.name = name;
			}

			public String getName() {
				return name;
			}

			public void setValue(String value) {
				this.value = value;
			}

			public String getValue() {
				return value;
			}

		}
	}
    
	

	public class PlayerTextures {

		private long timestamp;

		private String profileId;

		private String profileName;

		private Textures textures;

		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}

		public long getTimestamp() {
			return timestamp;
		}

		public void setProfileId(String profileId) {
			this.profileId = profileId;
		}

		public String getProfileId() {
			return profileId;
		}

		public void setProfileName(String profileName) {
			this.profileName = profileName;
		}

		public String getProfileName() {
			return profileName;
		}

		public void setTextures(Textures textures) {
			this.textures = textures;
		}

		public Textures getTextures() {
			return textures;
		}

		public class Textures {

			private SKIN SKIN;

			public void setSKIN(SKIN SKIN) {
				this.SKIN = SKIN;
			}

			public SKIN getSKIN() {
				return SKIN;
			}

			public class SKIN {

				private String url;

				public void setUrl(String url) {
					this.url = url;
				}

				public String getUrl() {
					return url;
				}

			}

		}

	}
	
	
	
}
