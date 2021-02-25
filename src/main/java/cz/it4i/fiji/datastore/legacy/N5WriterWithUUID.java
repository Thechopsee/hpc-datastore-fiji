/*******************************************************************************
 * IT4Innovations - National Supercomputing Center
 * Copyright (c) 2017 - 2021 All Right Reserved, https://www.it4i.cz
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE', which is part of this project.
 ******************************************************************************/
package cz.it4i.fiji.datastore.legacy;

import java.util.UUID;

import org.janelia.saalfeldlab.n5.N5Writer;

public interface N5WriterWithUUID extends N5Writer {

	UUID getUUID();

	void setUUID(UUID uuid);
}
