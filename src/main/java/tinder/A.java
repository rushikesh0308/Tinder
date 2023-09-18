package tinder;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class A extends Authenticator
{
	@Override
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("rushikeshss1632@gmail.com", "upvdvtlytyjpuhxr");
	
	}
}
