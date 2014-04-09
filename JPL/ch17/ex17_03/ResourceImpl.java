package ch17.ex17_03;

import java.lang.ref.WeakReference;

public class ResourceImpl implements Resource {
	/* key は強い参照を保持していないことが重要*/
	WeakReference<Object> key;
	boolean needsRelease = false;

	ResourceImpl(Object key) {
		key = new WeakReference<Object>(key);
		//
		needsRelease = true;
	}

	public void use(Object key, Object... args) {
		if (!this.key.get().equals(key)) {
			throw new IllegalArgumentException("wrong key");
		}
		//
	}

	public void release() {
		if (needsRelease) {
			needsRelease = false;
			//
			key.clear();
		}
	}

}
