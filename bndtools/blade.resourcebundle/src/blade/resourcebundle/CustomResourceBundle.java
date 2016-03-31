package blade.resourcebundle;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.*;

@Component(
	immediate = true, property = {"language.id=en_US"},
	service = ResourceBundle.class
)
public class CustomResourceBundle extends ResourceBundle {

	@Override
	protected Object handleGetObject(String key) {
		return _resourceBundle.getObject(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		return _resourceBundle.getKeys();
	}

	private final ResourceBundle _resourceBundle = ResourceBundle.getBundle(
		"content.Language");

}