package org.netloan;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class UserImportSelector implements ImportSelector {

	public String[] selectImports(AnnotationMetadata importingClassMetadata) {

		return new String[] { UserConfiguration.class.getName() };
	}
}
