package cz.it4i.fiji.legacy;

import cz.it4i.fiji.rest.util.DatasetInfo;
import org.scijava.ItemIO;
import org.scijava.command.Command;
import org.scijava.log.LogLevel;
import org.scijava.log.LogService;
import org.scijava.log.Logger;
import org.scijava.plugin.Parameter;
import org.scijava.plugin.Plugin;
import java.io.IOException;

@Plugin(type = Command.class, headless = false, menuPath = "Plugins>HPC DataStore>Query>Dataset info")
public class QueryDatasetInfo implements Command {
	@Parameter(label = "URL of a DatasetsRegisterService:")
	public String url = "someHostname:9080";

	@Parameter(label = "UUID of the dataset to be queried:")
	public String datasetID = "someDatasetUUID";

	@Parameter
	public LogService mainLogger;
	protected Logger myLogger;

	@Override
	public void run() {
		//logging facility
		myLogger = mainLogger.subLogger("HPC QueryDataset", LogLevel.INFO);

		try {
			myLogger.info("Quering "+datasetID+" from "+url);
			DatasetInfo di = DatasetInfo.createFrom(url, datasetID);
			datasetInfo = di.toString();
		} catch (IOException e) {
			myLogger.error("Some connection problem:");
			e.printStackTrace();
		}
	}

	@Parameter(type = ItemIO.OUTPUT, label="All info about the queried dataset:")
	public String datasetInfo = "(likely a connection error)";
}
