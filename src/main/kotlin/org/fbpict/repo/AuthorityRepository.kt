package org.fbpict.repo

import org.fbpict.entity.Authority
import org.springframework.data.jpa.repository.JpaRepository

/**
 * Created by Pavel on 9/29/2015.
 */
interface AuthorityRepository : JpaRepository<Authority, String>
