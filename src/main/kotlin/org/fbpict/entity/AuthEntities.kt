package org.fbpict.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

/**
 * Created by Pavel on 1/16/2016.
 */
@Entity
@Table(name = "authorities")
data class Authority(@Id val username:String, val authority: String)

/**
 * Created by Pavel on 1/16/2016.
 */
@Entity
@Table(name = "users")
class User(@Id
           val username: String,
           val password: String,
           val enabled: Boolean)

/**
 * Created by Pavel on 1/16/2016.
 */
@Entity
@Table(name = "userconnection")
data class UserConnection(@Id val userid: String,
                          val providerid: String,
                          val provideruserid: String,
                          val rank: Int = 0,
                          val displayname: String,
                          val profileurl: String,
                          val imageurl: String,
                          val accesstoken: String,
                          val secret: String,
                          val refreshtoken: String,
                          val expiretime: Long)

/**
 * Created by Pavel on 1/16/2016.
 */
@Entity
@Table(name = "userprofile")
data class UserProfile(@Id val userid: String, val name: String?, val firstname: String, val lastname: String,
                       val email: String, val username: String) {


    //{ "id", "about", "age_range", "birthday", "context", "cover", "currency", "devices", "education", "email", "favorite_athletes", "favorite_teams", "first_name", "gender", "hometown", "inspirational_people", "installed", "install_type", "is_verified", "languages", "last_name", "link", "locale", "location", "meeting_for", "middle_name", "name", "name_format", "political", "quotes", "payment_pricepoints", "relationship_status", "religion", "security_settings", "significant_other", "sports", "test_group", "timezone", "third_party_id", "updated_time", "verified", "video_upload_limits", "viewer_can_send_gift", "website", "work"}
    constructor(userId: String, up: org.springframework.social.facebook.api.User): this(userId,up.name, up.firstName, up.lastName, up.email, "")

}