/*
 * Copyright (c) 2020 SAP SE or an SAP affiliate company. All rights reserved.
 */
package de.hybris.training.setup;

import static de.hybris.training.constants.DemoExtensionConstants.PLATFORM_LOGO_CODE;

import de.hybris.platform.core.initialization.SystemSetup;

import java.io.InputStream;

import de.hybris.training.constants.DemoExtensionConstants;
import de.hybris.training.service.DemoExtensionService;


@SystemSetup(extension = DemoExtensionConstants.EXTENSIONNAME)
public class DemoExtensionSystemSetup
{
	private final DemoExtensionService demoExtensionService;

	public DemoExtensionSystemSetup(final DemoExtensionService demoExtensionService)
	{
		this.demoExtensionService = demoExtensionService;
	}

	@SystemSetup(process = SystemSetup.Process.INIT, type = SystemSetup.Type.ESSENTIAL)
	public void createEssentialData()
	{
		demoExtensionService.createLogo(PLATFORM_LOGO_CODE);
	}

	private InputStream getImageStream()
	{
		return DemoExtensionSystemSetup.class.getResourceAsStream("/demoExtension/sap-hybris-platform.png");
	}
}
