/*******************************************************************************
 * Copyright 2012 University of Southern California
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * This code was developed by the Information Integration Group as part 
 * of the Karma project at the Information Sciences Institute of the 
 * University of Southern California.  For more information, publications, 
 * and related projects, please see: http://www.isi.edu/integration
 ******************************************************************************/
/**
 * 
 */
package edu.isi.karma.controller.update;

import java.io.PrintWriter;

import edu.isi.karma.util.JSONUtil;
import edu.isi.karma.view.VWorksheetList;
import edu.isi.karma.view.VWorkspace;

/**
 * Contains the list of worksheets to be shown in the window. The list may
 * include new worksheets that were not previously displayed, and may not
 * inlcude worksheets that were previously displayed. Those should be removed.
 * 
 * @author szekely
 * 
 */
public class WorksheetListUpdate extends AbstractUpdate {

	public enum JsonKeys {
		worksheets, worksheetId, title, isUpToDate, isCollapsed
	}

	private final VWorksheetList vWorksheetList;

	public WorksheetListUpdate(VWorksheetList vWorksheetList) {
		super();
		this.vWorksheetList = vWorksheetList;
	}

	@Override
	public void generateJson(String prefix, PrintWriter pw, VWorkspace vWorkspace) {
		pw.println(prefix + "{");
		String prefix1 = prefix + "  ";
		pw.println(prefix1
				+ JSONUtil.json(GenericJsonKeys.updateType, getUpdateType()));
		pw.println(prefix1 + JSONUtil.jsonStartList(JsonKeys.worksheets));
		vWorksheetList.generateJson(prefix1, pw, vWorkspace.getViewFactory());
		pw.println(prefix1 + "]");
		pw.println(prefix + "}");

	}

}
