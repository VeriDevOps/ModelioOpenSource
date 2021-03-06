/* 
 * Copyright 2013-2020 Modeliosoft
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package org.modelio.module.modelermodule.command;

import java.util.List;
import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.eclipse.jface.dialogs.MessageDialog;
import org.modelio.api.modelio.model.IModelingSession;
import org.modelio.api.modelio.model.ITransaction;
import org.modelio.api.module.IModule;
import org.modelio.api.module.command.DefaultModuleCommandHandler;
import org.modelio.metamodel.uml.behavior.interactionModel.Lifeline;
import org.modelio.metamodel.uml.behavior.interactionModel.Message;
import org.modelio.metamodel.uml.behavior.interactionModel.MessageSort;
import org.modelio.module.modelermodule.api.ModelerModuleException;
import org.modelio.module.modelermodule.engine.InstanceUpdater;
import org.modelio.module.modelermodule.gui.ShellHelper;
import org.modelio.module.modelermodule.i18n.I18nMessageService;
import org.modelio.vcore.smkernel.mapi.MObject;

/**
 * Create an operation from a message. An Instance might be created in the process, or a Classifier.
 * 
 * @see InstanceUpdater#createInstanceAndClassifier(IModelingSession, Lifeline)
 */
@objid ("cf4c537f-e500-4ba5-9305-7c8c2d0f95e7")
public class CreateOperation extends DefaultModuleCommandHandler {
    @objid ("73217936-2c78-4b7b-b179-a003430dfcb1")
    @Override
    public void actionPerformed(final List<MObject> selectedElements, final IModule module) {
        IModelingSession session = module.getModuleContext().getModelingSession();
        
        try (ITransaction transaction = session.createTransaction("CreateOperation")) {
            InstanceUpdater p = new InstanceUpdater();
            p.createOperation(session, (Message) selectedElements.get(0));
        
            transaction.commit();
        } catch (ModelerModuleException e) {
            MessageDialog.openError(ShellHelper.findActiveShell(),
                    I18nMessageService.getString("Ui.Error.Title"),
                    e.getMessage());
        }
        
    }

    /**
     * This methods authorizes a command to be displayed in a defined context. The commands are displayed, by default, depending on the kind of metaclass on which the command has been launched.
     */
    @objid ("27272e23-f6c5-45c3-98ce-bf4f0d829a62")
    @Override
    public boolean accept(final List<MObject> selectedElements, final IModule module) {
        if (!super.accept(selectedElements, module)) {
            return false;
        }
        if (selectedElements.size() != 1) {
            return false;
        }
        Message message = (Message) selectedElements.get(0);
        
        // The command is not active for messages not covering a lifeline
        List<Lifeline> covered = message.getReceiveEvent().getCovered();
        if (covered.size() != 1) {
            return false;
        }
        
        MessageSort sort = message.getSortOfMessage();
        
        // The command is not active for return message and asynchronous messages
        return (sort != MessageSort.RETURNMESSAGE && sort != MessageSort.ASYNCCALL && sort != MessageSort.ASYNCSIGNAL);
    }

    /**
     * This method indicates if a command has to be deactivated. If the command has to be displayed (which means that the accept method has returned a positive value, it is sometimes needed to deactivate the command depending on specific constraints that
     * are specific to the MDAC.
     */
    @objid ("62a69ea3-f5a6-4ff2-b735-9e5bbe73edbe")
    @Override
    public boolean isActiveFor(final List<MObject> selectedElements, final IModule module) {
        if (!super.isActiveFor(selectedElements, module)) {
            return false;
        }
        return true;
    }

}
