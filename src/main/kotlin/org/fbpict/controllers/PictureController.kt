package org.fbpict.controllers


import org.fbpict.services.FbApiProvider
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import java.awt.Color
import java.awt.Font
import java.awt.GraphicsEnvironment
import java.awt.image.BufferedImage
import java.io.ByteArrayOutputStream
import java.security.Principal
import javax.imageio.ImageIO


@RestController
internal class PictureController {

    @Autowired
    lateinit var apiProvider: FbApiProvider

    @ResponseBody
    @RequestMapping("/likes", method = [RequestMethod.GET], produces = [MediaType.IMAGE_JPEG_VALUE])
    fun getGroups(currentUser: Principal): ByteArray {

        val fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().availableFontFamilyNames


        val userId = currentUser.name
        val api = apiProvider.getAPI(userId)
        val bufferedImage = BufferedImage(170, 4000,
                BufferedImage.TYPE_INT_RGB)
        val graphics = bufferedImage.graphics
        graphics.color = Color.LIGHT_GRAY
        graphics.fillRect(0, 0, 200, 4000)
        graphics.color = Color.BLACK

        val font = Font("David", Font.PLAIN, 16)
        graphics.font = font
        graphics.drawString("מי עושה", 10, 16)

        val baos = ByteArrayOutputStream()
        ImageIO.write(bufferedImage, "jpg", baos)
        baos.flush()
        val imageInByte = baos.toByteArray()!!
        baos.close()
        return imageInByte
    }

}
