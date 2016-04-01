package blade.corejsphook;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.*;

import com.liferay.portal.deploy.hot.CustomJspBag;
import com.liferay.portal.kernel.url.URLContainer;

@Component(
	immediate = true,
	property = {
		"context.id=BladeCustomJspBag",
		"context.name=Test Custom JSP Bag",
		"service.ranking:Integer=100"
	}
)
public class BladeCustomJspBag implements CustomJspBag {

	@Activate
	protected void activate(BundleContext bundleContext) {
		bundle = bundleContext.getBundle();

		_customJsps = new ArrayList<>();

		Enumeration<URL> entries = bundle.findEntries(
			getCustomJspDir(), "*.jsp", true);

		while (entries.hasMoreElements()) {
			URL url = entries.nextElement();

			_customJsps.add(url.getPath());
		}
	}

	@Override
	public String getCustomJspDir() {
		return "META-INF/jsps/";
	}

	@Override
	public List<String> getCustomJsps() {
		return _customJsps;
	}

	@Override
	public URLContainer getURLContainer() {
		return _urlContainer;
	}

	@Override
	public boolean isCustomJspGlobal() {
		return true;
	}

	private List<String> _customJsps;

	private final URLContainer _urlContainer = new URLContainer() {

		@Override
		public Set<String> getResources(String path) {
			Set<String> paths = new HashSet<>();

			for (String entry : _customJsps) {
				if (entry.startsWith(path)) {
					paths.add(entry);
				}
			}

			return paths;
		}

		@Override
		public URL getResource(String name) {
			return bundle.getEntry(name);
		}

	};

	private Bundle bundle;

}
