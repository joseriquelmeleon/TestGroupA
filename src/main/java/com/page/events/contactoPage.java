package com.page.events;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mail.TLSEmail;
import com.utils.Base;

public class contactoPage extends Base {

	By btncontacto = By.id("menu-item-1490");
	By contactoLocator = By.cssSelector("#post-1487 > div > div > div > div.et_pb_section.et_pb_section_0.et_section_regular > div.et_pb_row.et_pb_row_0 > div > div > div > h1 > strong");
	By messageLocator = By.cssSelector("#et_pb_contact_form_0 > h1");

	private static final String ASUNTO_CORREO = "Link de pagina caido - TestGroup.cl ";

	String asuntoAdicional = "";

	public contactoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void ContactoPage() throws InterruptedException {

		click(btncontacto);
		Thread.sleep(2000);

		WebElement mensaje = driver.findElement(btncontacto);

		if (isDisplayed(contactoLocator)) {
			System.out.println("La pagina contacto esta funcionando correctamente");
			
		} else {
			System.out.println("Hubo un problema con la pagina Contacto");
			String[] sCorreos = { "nelson.colman@testgroup.cl" };
			String mensajeCorreo = "<p>*********  Advertencia  *********</p>"
					+ "<p>Se ha detectado la caída del servicio web de Testgroup en el siguiente Link:"
					+ mensaje.getText() + " </b></p>";

			asuntoAdicional = "";

			TLSEmail.sendEmail(sCorreos, ASUNTO_CORREO + asuntoAdicional, mensajeCorreo);
			System.out.println("Asunto del Correo: " + ASUNTO_CORREO + asuntoAdicional);

		}
	}

	public String nosotrosMessage() {
		List<WebElement> span = findElements(messageLocator);
		return getText(span.get(0));

	}

}
