/* 
 * Copyright 2013-2020 Modeliosoft
 * 
 * This file is part of Modelio.
 * 
 * Modelio is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Modelio is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Modelio.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
package org.modelio.uml.ui.dg;

import com.modeliosoft.modelio.javadesigner.annotations.objid;
import org.modelio.api.modelio.diagram.IDiagramHandle;
import org.modelio.api.modelio.diagram.IDiagramLink;
import org.modelio.api.modelio.diagram.IDiagramNode;
import org.modelio.bpmn.diagram.editor.elements.bpmnadhocsubprocess.GmBpmnAdHocSubProcess;
import org.modelio.bpmn.diagram.editor.elements.bpmnboundaryevent.GmBpmnBoundaryEvent;
import org.modelio.bpmn.diagram.editor.elements.bpmnbusinessruletask.GmBpmnBusinessRuleTask;
import org.modelio.bpmn.diagram.editor.elements.bpmncallactivity.GmBpmnCallActivity;
import org.modelio.bpmn.diagram.editor.elements.bpmncomplexgateway.GmBpmnComplexGateway;
import org.modelio.bpmn.diagram.editor.elements.bpmndataassociation.GmBpmnDataAssociation;
import org.modelio.bpmn.diagram.editor.elements.bpmndataobject.datainput.GmBpmnDataInput;
import org.modelio.bpmn.diagram.editor.elements.bpmndataobject.dataobject.GmBpmnDataObject;
import org.modelio.bpmn.diagram.editor.elements.bpmndataobject.dataoutput.GmBpmnDataOutput;
import org.modelio.bpmn.diagram.editor.elements.bpmndataobject.datastore.GmBpmnDataStore;
import org.modelio.bpmn.diagram.editor.elements.bpmnendevent.GmBpmnEndEvent;
import org.modelio.bpmn.diagram.editor.elements.bpmneventbasedgateway.GmBpmnEventBasedGateway;
import org.modelio.bpmn.diagram.editor.elements.bpmnexclusivegateway.GmBpmnExclusiveGateway;
import org.modelio.bpmn.diagram.editor.elements.bpmninclusivegateway.GmBpmnInclusiveGateway;
import org.modelio.bpmn.diagram.editor.elements.bpmnintermediatecatchevent.GmBpmnIntermediateCatchEvent;
import org.modelio.bpmn.diagram.editor.elements.bpmnintermediatethrowevent.GmBpmnIntermediateThrowEvent;
import org.modelio.bpmn.diagram.editor.elements.bpmnlane.GmBpmnLane;
import org.modelio.bpmn.diagram.editor.elements.bpmnlanesetcontainer.GmBpmnLaneSetContainer;
import org.modelio.bpmn.diagram.editor.elements.bpmnmanualtask.GmBpmnManualTask;
import org.modelio.bpmn.diagram.editor.elements.bpmnmessage.GmBpmnMessage;
import org.modelio.bpmn.diagram.editor.elements.bpmnmessageflow.GmBpmnMessageFlow;
import org.modelio.bpmn.diagram.editor.elements.bpmnnodefooter.GmBpmnNodeFooter;
import org.modelio.bpmn.diagram.editor.elements.bpmnnodeheader.GmBpmnNodeHeader;
import org.modelio.bpmn.diagram.editor.elements.bpmnparallelgateway.GmBpmnParallelGateway;
import org.modelio.bpmn.diagram.editor.elements.bpmnreceivetask.GmBpmnReceiveTask;
import org.modelio.bpmn.diagram.editor.elements.bpmnsendtask.GmBpmnSendTask;
import org.modelio.bpmn.diagram.editor.elements.bpmnsequenceflow.GmBpmnSequenceFlow;
import org.modelio.bpmn.diagram.editor.elements.bpmnservicetask.GmBpmnServiceTask;
import org.modelio.bpmn.diagram.editor.elements.bpmnsripttask.GmBpmnScriptTask;
import org.modelio.bpmn.diagram.editor.elements.bpmnstartevent.GmBpmnStartEvent;
import org.modelio.bpmn.diagram.editor.elements.bpmnsubprocess.GmBpmnSubProcess;
import org.modelio.bpmn.diagram.editor.elements.bpmntask.GmBpmnTask;
import org.modelio.bpmn.diagram.editor.elements.bpmntransaction.GmBpmnTransaction;
import org.modelio.bpmn.diagram.editor.elements.bpmnusertask.GmBpmnUserTask;
import org.modelio.bpmn.diagram.editor.elements.diagrams.processcollaboration.GmBpmnProcessCollaborationDiagram;
import org.modelio.bpmn.diagram.editor.elements.diagrams.processdesign.GmBpmnProcessDesignDiagram;
import org.modelio.bpmn.diagram.editor.elements.diagrams.subprocess.GmBpmnSubProcessDiagram;
import org.modelio.bpmn.diagram.editor.elements.participant.GmBpmnParticipantPortContainer;
import org.modelio.diagram.api.dg.IDGFactory;
import org.modelio.diagram.api.dg.common.LabelDG;
import org.modelio.diagram.api.dg.common.LeafNodeDG;
import org.modelio.diagram.api.dg.common.LeafPortContainerDG;
import org.modelio.diagram.api.services.DiagramHandle;
import org.modelio.diagram.elements.core.model.IGmLink;
import org.modelio.diagram.elements.core.node.GmNodeModel;
import org.modelio.uml.activitydiagram.editor.elements.acceptsignal.GmAcceptSignal;
import org.modelio.uml.activitydiagram.editor.elements.action.GmAction;
import org.modelio.uml.activitydiagram.editor.elements.activitydiagram.GmActivityDiagram;
import org.modelio.uml.activitydiagram.editor.elements.activityfinal.GmActivityFinal;
import org.modelio.uml.activitydiagram.editor.elements.callbehavior.GmCallBehavior;
import org.modelio.uml.activitydiagram.editor.elements.callevent.GmCallEvent;
import org.modelio.uml.activitydiagram.editor.elements.calloperation.GmCallOperation;
import org.modelio.uml.activitydiagram.editor.elements.centralbuffer.GmCentralBuffer;
import org.modelio.uml.activitydiagram.editor.elements.changeevent.GmChangeEvent;
import org.modelio.uml.activitydiagram.editor.elements.clause.GmClause;
import org.modelio.uml.activitydiagram.editor.elements.conditional.GmConditional;
import org.modelio.uml.activitydiagram.editor.elements.controlflow.GmControlFlow;
import org.modelio.uml.activitydiagram.editor.elements.datastore.GmDataStore;
import org.modelio.uml.activitydiagram.editor.elements.decisionmerge.GmDecisionMerge;
import org.modelio.uml.activitydiagram.editor.elements.exceptionhandler.GmExceptionHandler;
import org.modelio.uml.activitydiagram.editor.elements.expansionnode.GmExpansionNode;
import org.modelio.uml.activitydiagram.editor.elements.expansionregion.GmExpansionRegion;
import org.modelio.uml.activitydiagram.editor.elements.flowfinal.GmFlowFinal;
import org.modelio.uml.activitydiagram.editor.elements.forkjoin.GmForkJoin;
import org.modelio.uml.activitydiagram.editor.elements.initial.GmInitial;
import org.modelio.uml.activitydiagram.editor.elements.inputpin.GmInputPin;
import org.modelio.uml.activitydiagram.editor.elements.interruptible.GmInterruptible;
import org.modelio.uml.activitydiagram.editor.elements.loopnode.GmLoopNode;
import org.modelio.uml.activitydiagram.editor.elements.objectflow.GmObjectFlow;
import org.modelio.uml.activitydiagram.editor.elements.objectnode.GmObjectNode;
import org.modelio.uml.activitydiagram.editor.elements.outputpin.GmOutputPin;
import org.modelio.uml.activitydiagram.editor.elements.partition.GmPartition;
import org.modelio.uml.activitydiagram.editor.elements.partitioncontainer.GmDiagramPartitionContainer;
import org.modelio.uml.activitydiagram.editor.elements.sendsignal.GmSendSignal;
import org.modelio.uml.activitydiagram.editor.elements.structuredactivity.GmStructuredActivity;
import org.modelio.uml.activitydiagram.editor.elements.timeevent.GmTimeEvent;
import org.modelio.uml.activitydiagram.editor.elements.valuepin.GmValuePin;
import org.modelio.uml.communicationdiagram.editor.elements.communicationchannel.GmCommunicationChannel;
import org.modelio.uml.communicationdiagram.editor.elements.communicationdiagram.GmCommunicationDiagram;
import org.modelio.uml.communicationdiagram.editor.elements.communicationnode.GmCommunicationNode;
import org.modelio.uml.deploymentdiagram.editor.elements.artifact.GmArtifact;
import org.modelio.uml.deploymentdiagram.editor.elements.deploymentdiagram.GmDeploymentDiagram;
import org.modelio.uml.deploymentdiagram.editor.elements.manifestation.GmManifestation;
import org.modelio.uml.deploymentdiagram.editor.elements.node.GmNode;
import org.modelio.uml.objectdiagram.editor.elements.objectdiagram.GmObjectDiagram;
import org.modelio.uml.sequencediagram.editor.elements.combinedfragment.GmCombinedFragment;
import org.modelio.uml.sequencediagram.editor.elements.executionoccurencespecification.GmExecutionOccurenceSpecification;
import org.modelio.uml.sequencediagram.editor.elements.executionspecification.GmExecutionSpecification;
import org.modelio.uml.sequencediagram.editor.elements.gate.GmGate;
import org.modelio.uml.sequencediagram.editor.elements.interactionoperand.GmInteractionOperand;
import org.modelio.uml.sequencediagram.editor.elements.interactionuse.GmInteractionUse;
import org.modelio.uml.sequencediagram.editor.elements.lifeline.GmLifeline;
import org.modelio.uml.sequencediagram.editor.elements.message.GmMessage;
import org.modelio.uml.sequencediagram.editor.elements.sequencediagram.GmSequenceDiagram;
import org.modelio.uml.sequencediagram.editor.elements.stateinvariant.GmStateInvariant;
import org.modelio.uml.statediagram.editor.elements.choice.GmChoice;
import org.modelio.uml.statediagram.editor.elements.connectionpoint.GmConnectionPoint;
import org.modelio.uml.statediagram.editor.elements.deephistory.GmDeepHistory;
import org.modelio.uml.statediagram.editor.elements.entry.GmEntry;
import org.modelio.uml.statediagram.editor.elements.exit.GmExitPoint;
import org.modelio.uml.statediagram.editor.elements.finalstate.GmFinalState;
import org.modelio.uml.statediagram.editor.elements.fork.GmForkState;
import org.modelio.uml.statediagram.editor.elements.initialstate.GmInitialState;
import org.modelio.uml.statediagram.editor.elements.internaltransition.GmInternalTransition;
import org.modelio.uml.statediagram.editor.elements.join.GmJoin;
import org.modelio.uml.statediagram.editor.elements.junction.GmJunction;
import org.modelio.uml.statediagram.editor.elements.region.GmRegion;
import org.modelio.uml.statediagram.editor.elements.shallowhistory.GmShallowHistory;
import org.modelio.uml.statediagram.editor.elements.state.GmState;
import org.modelio.uml.statediagram.editor.elements.statediagram.GmStateDiagram;
import org.modelio.uml.statediagram.editor.elements.terminal.GmTerminal;
import org.modelio.uml.statediagram.editor.elements.transition.GmTransition;
import org.modelio.uml.statikdiagram.editor.elements.activity.GmActivity;
import org.modelio.uml.statikdiagram.editor.elements.association.GmAssociation;
import org.modelio.uml.statikdiagram.editor.elements.associationclass.GmClassAssociationLink;
import org.modelio.uml.statikdiagram.editor.elements.attribute.GmAttribute;
import org.modelio.uml.statikdiagram.editor.elements.binding.GmBindingLabel;
import org.modelio.uml.statikdiagram.editor.elements.bindinglink.GmBindingLink;
import org.modelio.uml.statikdiagram.editor.elements.bpmnbehavior.GmBpmnBehavior;
import org.modelio.uml.statikdiagram.editor.elements.bpmncollaboration.GmBpmnCollaboration;
import org.modelio.uml.statikdiagram.editor.elements.bpmnprocess.GmBpmnProcess;
import org.modelio.uml.statikdiagram.editor.elements.bpmnsharedefinition.GmBpmnSharedDefinitions;
import org.modelio.uml.statikdiagram.editor.elements.clazz.GmClass;
import org.modelio.uml.statikdiagram.editor.elements.collab.GmCollaboration;
import org.modelio.uml.statikdiagram.editor.elements.collabuse.GmCollaborationUse;
import org.modelio.uml.statikdiagram.editor.elements.communicationinteraction.GmCommunicationInteraction;
import org.modelio.uml.statikdiagram.editor.elements.component.GmComponent;
import org.modelio.uml.statikdiagram.editor.elements.connector.GmConnectorLink;
import org.modelio.uml.statikdiagram.editor.elements.constraint.GmConstraintBody;
import org.modelio.uml.statikdiagram.editor.elements.datatype.GmDataType;
import org.modelio.uml.statikdiagram.editor.elements.elementimport.GmElementImport;
import org.modelio.uml.statikdiagram.editor.elements.enumeration.GmEnum;
import org.modelio.uml.statikdiagram.editor.elements.enumliteral.GmEnumLitteral;
import org.modelio.uml.statikdiagram.editor.elements.generalization.GmGeneralization;
import org.modelio.uml.statikdiagram.editor.elements.informationflowlink.GmInformationFlowLink;
import org.modelio.uml.statikdiagram.editor.elements.informationitem.GmInformationItem;
import org.modelio.uml.statikdiagram.editor.elements.instance.GmInstance;
import org.modelio.uml.statikdiagram.editor.elements.instancelink.GmInstanceLink;
import org.modelio.uml.statikdiagram.editor.elements.interaction.GmInteraction;
import org.modelio.uml.statikdiagram.editor.elements.interfaze.GmInterface;
import org.modelio.uml.statikdiagram.editor.elements.operation.GmOperation;
import org.modelio.uml.statikdiagram.editor.elements.packageimport.GmPackageImport;
import org.modelio.uml.statikdiagram.editor.elements.packagemerge.GmPackageMerge;
import org.modelio.uml.statikdiagram.editor.elements.packaze.GmPackage;
import org.modelio.uml.statikdiagram.editor.elements.ports.GmPort;
import org.modelio.uml.statikdiagram.editor.elements.providedinterface.GmProvidedInterfaceLink;
import org.modelio.uml.statikdiagram.editor.elements.raisedexception.GmRaisedException;
import org.modelio.uml.statikdiagram.editor.elements.realization.GmInterfaceRealization;
import org.modelio.uml.statikdiagram.editor.elements.requiredinterface.GmRequiredInterfaceLink;
import org.modelio.uml.statikdiagram.editor.elements.signal.GmSignal;
import org.modelio.uml.statikdiagram.editor.elements.slot.GmSlot;
import org.modelio.uml.statikdiagram.editor.elements.statemachine.GmStateMachine;
import org.modelio.uml.statikdiagram.editor.elements.staticdiagram.GmStaticDiagram;
import org.modelio.uml.statikdiagram.editor.elements.templatebinding.GmTemplateBinding;
import org.modelio.uml.ui.dg.activity.ActivityDiagramDG;
import org.modelio.uml.ui.dg.activity.ActivityPartitionDG;
import org.modelio.uml.ui.dg.activity.ClauseDG;
import org.modelio.uml.ui.dg.activity.ConditionalNodeDG;
import org.modelio.uml.ui.dg.activity.ControlFlowDG;
import org.modelio.uml.ui.dg.activity.DiagramPartitionContainerDG;
import org.modelio.uml.ui.dg.activity.ExceptionHandlerDG;
import org.modelio.uml.ui.dg.activity.ExpansionRegionDG;
import org.modelio.uml.ui.dg.activity.InterruptibleActivityRegionDG;
import org.modelio.uml.ui.dg.activity.LoopNodeDG;
import org.modelio.uml.ui.dg.activity.ObjectFlowDG;
import org.modelio.uml.ui.dg.activity.StructuredActivityNodeDG;
import org.modelio.uml.ui.dg.bpmn.BpmnAdHocSubProcessDG;
import org.modelio.uml.ui.dg.bpmn.BpmnBoundaryEventDG;
import org.modelio.uml.ui.dg.bpmn.BpmnBusinessRuleTaskDG;
import org.modelio.uml.ui.dg.bpmn.BpmnCallActivityDG;
import org.modelio.uml.ui.dg.bpmn.BpmnComplexGatewayDG;
import org.modelio.uml.ui.dg.bpmn.BpmnDataAssociationDG;
import org.modelio.uml.ui.dg.bpmn.BpmnEndEventDG;
import org.modelio.uml.ui.dg.bpmn.BpmnEventBasedGatewayDG;
import org.modelio.uml.ui.dg.bpmn.BpmnExclusiveGatewayDG;
import org.modelio.uml.ui.dg.bpmn.BpmnInclusiveGatewayDG;
import org.modelio.uml.ui.dg.bpmn.BpmnIntermediateCatchEventDG;
import org.modelio.uml.ui.dg.bpmn.BpmnIntermediateThrowEventDG;
import org.modelio.uml.ui.dg.bpmn.BpmnLaneDG;
import org.modelio.uml.ui.dg.bpmn.BpmnLaneSetContainerDG;
import org.modelio.uml.ui.dg.bpmn.BpmnManualTaskDG;
import org.modelio.uml.ui.dg.bpmn.BpmnMessageDG;
import org.modelio.uml.ui.dg.bpmn.BpmnMessageFlowDG;
import org.modelio.uml.ui.dg.bpmn.BpmnParallelGatewayDG;
import org.modelio.uml.ui.dg.bpmn.BpmnParticipantDG;
import org.modelio.uml.ui.dg.bpmn.BpmnProcessCollaborationDiagramDG;
import org.modelio.uml.ui.dg.bpmn.BpmnProcessDesignDiagramDG;
import org.modelio.uml.ui.dg.bpmn.BpmnReceiveTaskDG;
import org.modelio.uml.ui.dg.bpmn.BpmnScriptTaskDG;
import org.modelio.uml.ui.dg.bpmn.BpmnSendTaskDG;
import org.modelio.uml.ui.dg.bpmn.BpmnSequenceFlowDG;
import org.modelio.uml.ui.dg.bpmn.BpmnServiceTaskDG;
import org.modelio.uml.ui.dg.bpmn.BpmnStartEventDG;
import org.modelio.uml.ui.dg.bpmn.BpmnSubProcessDG;
import org.modelio.uml.ui.dg.bpmn.BpmnSubProcessDiagramDG;
import org.modelio.uml.ui.dg.bpmn.BpmnTaskDG;
import org.modelio.uml.ui.dg.bpmn.BpmnTransactionDG;
import org.modelio.uml.ui.dg.bpmn.BpmnUserTaskDG;
import org.modelio.uml.ui.dg.common.PackageDG;
import org.modelio.uml.ui.dg.communication.CommunicationChannelDG;
import org.modelio.uml.ui.dg.communication.CommunicationDiagramDG;
import org.modelio.uml.ui.dg.communication.CommunicationNodeDG;
import org.modelio.uml.ui.dg.constraint.ConstraintDG;
import org.modelio.uml.ui.dg.deployment.ArtifactDG;
import org.modelio.uml.ui.dg.deployment.DeploymentDiagramDG;
import org.modelio.uml.ui.dg.deployment.ManifestationDG;
import org.modelio.uml.ui.dg.deployment.NodeDG;
import org.modelio.uml.ui.dg.object.ObjectDiagramDG;
import org.modelio.uml.ui.dg.sequence.CombinedFragmentDG;
import org.modelio.uml.ui.dg.sequence.ExecutionOccurenceSpecificationDG;
import org.modelio.uml.ui.dg.sequence.ExecutionSpecificationDG;
import org.modelio.uml.ui.dg.sequence.GateDG;
import org.modelio.uml.ui.dg.sequence.InteractionOperandDG;
import org.modelio.uml.ui.dg.sequence.InteractionUseDG;
import org.modelio.uml.ui.dg.sequence.LifelineDG;
import org.modelio.uml.ui.dg.sequence.MessageDG;
import org.modelio.uml.ui.dg.sequence.SequenceDiagramDG;
import org.modelio.uml.ui.dg.sequence.StateInvariantDG;
import org.modelio.uml.ui.dg.state.RegionDG;
import org.modelio.uml.ui.dg.state.StateDG;
import org.modelio.uml.ui.dg.state.StateDiagramDG;
import org.modelio.uml.ui.dg.state.TransitionDG;
import org.modelio.uml.ui.dg.statik.ActivityDG;
import org.modelio.uml.ui.dg.statik.AssociationDG;
import org.modelio.uml.ui.dg.statik.BindingLinkDG;
import org.modelio.uml.ui.dg.statik.BpmnBehaviorDG;
import org.modelio.uml.ui.dg.statik.BpmnCollaborationDG;
import org.modelio.uml.ui.dg.statik.BpmnProcessDG;
import org.modelio.uml.ui.dg.statik.BpmnSharedDefinitionsDG;
import org.modelio.uml.ui.dg.statik.ClassAssociationDG;
import org.modelio.uml.ui.dg.statik.ClassDG;
import org.modelio.uml.ui.dg.statik.CollaborationDG;
import org.modelio.uml.ui.dg.statik.CollaborationUseDG;
import org.modelio.uml.ui.dg.statik.CommunicationInteractionDG;
import org.modelio.uml.ui.dg.statik.ComponentDG;
import org.modelio.uml.ui.dg.statik.ConnectorDG;
import org.modelio.uml.ui.dg.statik.DataTypeDG;
import org.modelio.uml.ui.dg.statik.ElementImportDG;
import org.modelio.uml.ui.dg.statik.EnumerationDG;
import org.modelio.uml.ui.dg.statik.GeneralizationDG;
import org.modelio.uml.ui.dg.statik.InformationFlowDG;
import org.modelio.uml.ui.dg.statik.InstanceDG;
import org.modelio.uml.ui.dg.statik.InteractionDG;
import org.modelio.uml.ui.dg.statik.InterfaceDG;
import org.modelio.uml.ui.dg.statik.InterfaceRealizationDG;
import org.modelio.uml.ui.dg.statik.LinkDG;
import org.modelio.uml.ui.dg.statik.PackageImportDG;
import org.modelio.uml.ui.dg.statik.PackageMergeDG;
import org.modelio.uml.ui.dg.statik.PortDG;
import org.modelio.uml.ui.dg.statik.ProvidedInterfaceDG;
import org.modelio.uml.ui.dg.statik.RaisedExceptionDG;
import org.modelio.uml.ui.dg.statik.RequiredInterfaceDG;
import org.modelio.uml.ui.dg.statik.SignalDG;
import org.modelio.uml.ui.dg.statik.StateMachineDG;
import org.modelio.uml.ui.dg.statik.StaticDiagramDG;
import org.modelio.uml.ui.dg.statik.TemplateBindingDG;
import org.modelio.uml.ui.dg.usecase.ActorDG;
import org.modelio.uml.ui.dg.usecase.SystemDG;
import org.modelio.uml.ui.dg.usecase.UseCaseDG;
import org.modelio.uml.ui.dg.usecase.UseCaseDependencyDG;
import org.modelio.uml.ui.dg.usecase.UseCaseDiagramDG;
import org.modelio.uml.usecasediagram.editor.elements.actor.GmActor;
import org.modelio.uml.usecasediagram.editor.elements.extensionpoint.GmExtensionPoint;
import org.modelio.uml.usecasediagram.editor.elements.system.GmSystem;
import org.modelio.uml.usecasediagram.editor.elements.usecase.GmUseCase;
import org.modelio.uml.usecasediagram.editor.elements.usecasedependency.GmUseCaseDependency;
import org.modelio.uml.usecasediagram.editor.elements.usecasediagram.GmUseCaseDiagram;

/**
 * Diagram graphic factory for the Uml metamodel fragment.
 */
@objid ("78e44873-22e0-4828-904e-e70d7b4336ac")
public class UmlDGFactory implements IDGFactory {
    @objid ("82230245-64ae-4e5c-97ff-c22802a2a37f")
    @Override
    public IDiagramLink getDiagramLink(IDiagramHandle diagramHandle, IGmLink gmLink) {
        IDiagramLink ret = getActivityLink((DiagramHandle) diagramHandle, gmLink);
        
        if (ret == null) {
            ret = getCommunicationLink((DiagramHandle) diagramHandle, gmLink);
        }
        
        if (ret == null) {
            ret = getDeploymentLink((DiagramHandle) diagramHandle, gmLink);
        }
        
        if (ret == null) {
            ret = getStateLink((DiagramHandle) diagramHandle, gmLink);
        }
        
        if (ret == null) {
            ret = getUseCaseLink((DiagramHandle) diagramHandle, gmLink);
        }
        
        if (ret == null) {
            ret = getStatikLink((DiagramHandle) diagramHandle, gmLink);
        }
        
        if (ret == null) {
            ret = getSequenceLink((DiagramHandle) diagramHandle, gmLink);
        }
        
        if (ret == null) {
            ret = getBpmnLink((DiagramHandle) diagramHandle, gmLink);
        }
        return ret;
    }

    @objid ("e335b8b4-6432-4f29-b73d-5799d4ada725")
    @Override
    public IDiagramNode getDiagramNode(IDiagramHandle diagramHandle, GmNodeModel gmNodeModel) {
        if (!gmNodeModel.isVisible()) {
            return null;
        }
        
        IDiagramNode ret = getActivityNode((DiagramHandle) diagramHandle, gmNodeModel);
        
        if (ret == null) {
            ret = getCommunicationNode((DiagramHandle) diagramHandle, gmNodeModel);
        }
        
        if (ret == null) {
            ret = getDeploymentNode((DiagramHandle) diagramHandle, gmNodeModel);
        }
        
        if (ret == null) {
            ret = getObjectNode((DiagramHandle) diagramHandle, gmNodeModel);
        }
        
        if (ret == null) {
            ret = getStateNode((DiagramHandle) diagramHandle, gmNodeModel);
        }
        
        if (ret == null) {
            ret = getUseCaseNode((DiagramHandle) diagramHandle, gmNodeModel);
        }
        
        if (ret == null) {
            ret = getStatikNode((DiagramHandle) diagramHandle, gmNodeModel);
        }
        
        if (ret == null) {
            ret = getSequenceNode((DiagramHandle) diagramHandle, gmNodeModel);
        }
        
        if (ret == null) {
            ret = getBpmnNode((DiagramHandle) diagramHandle, gmNodeModel);
        }
        
        if (ret == null) {
            ret = getCommonNode((DiagramHandle) diagramHandle, gmNodeModel);
        }
        return ret;
    }

    @objid ("1edae2f8-6e49-4959-a9a0-c67efed757ae")
    private IDiagramLink getActivityLink(final DiagramHandle diagramHandle, final IGmLink gmLink) {
        // GmControlFlow
        if (gmLink instanceof GmControlFlow) {
            return new ControlFlowDG(diagramHandle, gmLink);
        }
        
        // GmExceptionHandler
        if (gmLink instanceof GmExceptionHandler) {
            return new ExceptionHandlerDG(diagramHandle, gmLink);
        }
        
        // GmObjectFlow
        if (gmLink instanceof GmObjectFlow) {
            return new ObjectFlowDG(diagramHandle, gmLink);
        }
        
        // This is not an activity link
        return null;
    }

    @objid ("8e817863-e4f0-4417-bfec-678172cd28b3")
    private IDiagramNode getActivityNode(final DiagramHandle diagramHandle, final GmNodeModel gmNodeModel) {
        // GmAcceptSignal
        if (gmNodeModel instanceof GmAcceptSignal) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmAction
        if (gmNodeModel instanceof GmAction) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmActivityDiagram
        if (gmNodeModel instanceof GmActivityDiagram) {
            return new ActivityDiagramDG(diagramHandle, gmNodeModel);
        }
        
        // GmActivityFinal
        if (gmNodeModel instanceof GmActivityFinal) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmCallBehavior
        if (gmNodeModel instanceof GmCallBehavior) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmCallEvent
        if (gmNodeModel instanceof GmCallEvent) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmCallOperation
        if (gmNodeModel instanceof GmCallOperation) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmCentralBuffer
        if (gmNodeModel instanceof GmCentralBuffer) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmChangeEvent
        if (gmNodeModel instanceof GmChangeEvent) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmClause
        if (gmNodeModel instanceof GmClause) {
            return new ClauseDG(diagramHandle, gmNodeModel);
        }
        
        // GmConditional
        if (gmNodeModel instanceof GmConditional) {
            return new ConditionalNodeDG(diagramHandle, gmNodeModel);
        }
        
        // GmDataStore
        if (gmNodeModel instanceof GmDataStore) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmDecisionMerge
        if (gmNodeModel instanceof GmDecisionMerge) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmDiagramPartitionContainer
        if (gmNodeModel instanceof GmDiagramPartitionContainer) {
            return new DiagramPartitionContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmExpansionNode
        if (gmNodeModel instanceof GmExpansionNode) {
            return new LeafNodeDG(diagramHandle, gmNodeModel);
        }
        
        // GmExpansionRegion
        if (gmNodeModel instanceof GmExpansionRegion) {
            return new ExpansionRegionDG(diagramHandle, gmNodeModel);
        }
        
        // GmFlowFinal
        if (gmNodeModel instanceof GmFlowFinal) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmForkJoin
        if (gmNodeModel instanceof GmForkJoin) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmInitial
        if (gmNodeModel instanceof GmInitial) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmInputPin
        if (gmNodeModel instanceof GmInputPin) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmInterruptible
        if (gmNodeModel instanceof GmInterruptible) {
            return new InterruptibleActivityRegionDG(diagramHandle, gmNodeModel);
        }
        
        // GmLoopNode
        if (gmNodeModel instanceof GmLoopNode) {
            return new LoopNodeDG(diagramHandle, gmNodeModel);
        }
        
        // GmObjectNode
        if (gmNodeModel instanceof GmObjectNode) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmOutputPin
        if (gmNodeModel instanceof GmOutputPin) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmPartition
        if (gmNodeModel instanceof GmPartition) {
            return new ActivityPartitionDG(diagramHandle, gmNodeModel);
        }
        
        // GmSendSignal
        if (gmNodeModel instanceof GmSendSignal) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmStructuredActivity
        if (gmNodeModel instanceof GmStructuredActivity) {
            return new StructuredActivityNodeDG(diagramHandle, gmNodeModel);
        }
        
        // GmTimeEvent
        if (gmNodeModel instanceof GmTimeEvent) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmValuePin
        if (gmNodeModel instanceof GmValuePin) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        return null;
    }

    @objid ("8dc2a40b-2477-4002-9bcf-5d0b0c84c613")
    private IDiagramLink getBpmnLink(final DiagramHandle diagramHandle, final IGmLink gmLink) {
        // GmBpmnDataAssociation
        if (gmLink instanceof GmBpmnDataAssociation) {
            return new BpmnDataAssociationDG(diagramHandle, gmLink);
        }
        
        // GmBpmnMessageFlow
        if (gmLink instanceof GmBpmnMessageFlow) {
            return new BpmnMessageFlowDG(diagramHandle, gmLink);
        }
        
        // GmBpmnSequenceFlow
        if (gmLink instanceof GmBpmnSequenceFlow) {
            return new BpmnSequenceFlowDG(diagramHandle, gmLink);
        }
        
        // This is not a bpmn link
        return null;
    }

    @objid ("a8d30694-8f39-49d7-8ba9-512297070b0e")
    private IDiagramNode getBpmnNode(final DiagramHandle diagramHandle, final GmNodeModel gmNodeModel) {
        // GmBpmnAdHocSubProcess
        if (gmNodeModel instanceof GmBpmnAdHocSubProcess) {
            return new BpmnAdHocSubProcessDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnBoundaryEvent
        if (gmNodeModel instanceof GmBpmnBoundaryEvent) {
            return new BpmnBoundaryEventDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnBusinessRuleTask
        if (gmNodeModel instanceof GmBpmnBusinessRuleTask) {
            return new BpmnBusinessRuleTaskDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnCallActivity
        if (gmNodeModel instanceof GmBpmnCallActivity) {
            return new BpmnCallActivityDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnComplexGateway
        if (gmNodeModel instanceof GmBpmnComplexGateway) {
            return new BpmnComplexGatewayDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnDataInput
        if (gmNodeModel instanceof GmBpmnDataInput) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnDataObject
        if (gmNodeModel instanceof GmBpmnDataObject) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnDataOutput
        if (gmNodeModel instanceof GmBpmnDataOutput) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnDataStore
        if (gmNodeModel instanceof GmBpmnDataStore) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnEndEvent
        if (gmNodeModel instanceof GmBpmnEndEvent) {
            return new BpmnEndEventDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnEventBasedGateway
        if (gmNodeModel instanceof GmBpmnEventBasedGateway) {
            return new BpmnEventBasedGatewayDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnExclusiveGateway
        if (gmNodeModel instanceof GmBpmnExclusiveGateway) {
            return new BpmnExclusiveGatewayDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnInclusiveGateway
        if (gmNodeModel instanceof GmBpmnInclusiveGateway) {
            return new BpmnInclusiveGatewayDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnIntermediateCatchEvent
        if (gmNodeModel instanceof GmBpmnIntermediateCatchEvent) {
            return new BpmnIntermediateCatchEventDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnIntermediateThrowEvent
        if (gmNodeModel instanceof GmBpmnIntermediateThrowEvent) {
            return new BpmnIntermediateThrowEventDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnLane
        if (gmNodeModel instanceof GmBpmnLane) {
            return new BpmnLaneDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnLaneSetContainer
        if (gmNodeModel instanceof GmBpmnLaneSetContainer) {
            return new BpmnLaneSetContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnManualTask
        if (gmNodeModel instanceof GmBpmnManualTask) {
            return new BpmnManualTaskDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnMessage
        if (gmNodeModel instanceof GmBpmnMessage) {
            return new BpmnMessageDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnNodeFooter
        if (gmNodeModel instanceof GmBpmnNodeFooter) {
            return new LeafNodeDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnNodeHeader
        if (gmNodeModel instanceof GmBpmnNodeHeader) {
            return new LeafNodeDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnParallelGateway
        if (gmNodeModel instanceof GmBpmnParallelGateway) {
            return new BpmnParallelGatewayDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnReceiveTask
        if (gmNodeModel instanceof GmBpmnReceiveTask) {
            return new BpmnReceiveTaskDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnSendTask
        if (gmNodeModel instanceof GmBpmnSendTask) {
            return new BpmnSendTaskDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnServiceTask
        if (gmNodeModel instanceof GmBpmnServiceTask) {
            return new BpmnServiceTaskDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnSriptTask
        if (gmNodeModel instanceof GmBpmnScriptTask) {
            return new BpmnScriptTaskDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnStartEvent
        if (gmNodeModel instanceof GmBpmnStartEvent) {
            return new BpmnStartEventDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnSubProcess
        if (gmNodeModel instanceof GmBpmnSubProcess) {
            return new BpmnSubProcessDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnTask
        if (gmNodeModel instanceof GmBpmnTask) {
            return new BpmnTaskDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnTransaction
        if (gmNodeModel instanceof GmBpmnTransaction) {
            return new BpmnTransactionDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnUserTask
        if (gmNodeModel instanceof GmBpmnUserTask) {
            return new BpmnUserTaskDG(diagramHandle, gmNodeModel);
        }
        
        // GmGmBpmnProcessCollaborationDiagram
        if (gmNodeModel instanceof GmBpmnProcessCollaborationDiagram) {
            return new BpmnProcessCollaborationDiagramDG(diagramHandle, gmNodeModel);
        }
        
        // GmGmBpmnSubProcessDiagram
        if (gmNodeModel instanceof GmBpmnSubProcessDiagram) {
            return new BpmnSubProcessDiagramDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnProcessDesignDiagram
        if (gmNodeModel instanceof GmBpmnProcessDesignDiagram) {
            return new BpmnProcessDesignDiagramDG(diagramHandle, gmNodeModel);
        }
        
        // GmBpmnParticipantPortContainer
        if (gmNodeModel instanceof GmBpmnParticipantPortContainer) {
            return new BpmnParticipantDG(diagramHandle, gmNodeModel);
        }
        
        // This is not a bpmn node
        return null;
    }

    @objid ("db7c60e2-9345-460e-a49a-8e19e7e3919d")
    private IDiagramNode getCommonNode(final DiagramHandle diagramHandle, final GmNodeModel gmNodeModel) {
        // GmConstraint
        if (gmNodeModel instanceof GmConstraintBody) {
            return new ConstraintDG(diagramHandle, gmNodeModel);
        }
        return null;
    }

    @objid ("b940e3c7-c256-41e6-8a67-57a00bfdd461")
    private IDiagramLink getCommunicationLink(final DiagramHandle diagramHandle, final IGmLink gmLinkModel) {
        // GmCommunicationChannel
        if (gmLinkModel instanceof GmCommunicationChannel) {
            return new CommunicationChannelDG(diagramHandle, gmLinkModel);
        }
        return null;
    }

    @objid ("848de394-9ae8-4771-b2c2-c158ad474159")
    private IDiagramNode getCommunicationNode(final DiagramHandle diagramHandle, final GmNodeModel gmNodeModel) {
        // GmCommunicationDiagram
        if (gmNodeModel instanceof GmCommunicationDiagram) {
            return new CommunicationDiagramDG(diagramHandle, gmNodeModel);
        }
        
        // GmCommunicationNode
        if (gmNodeModel instanceof GmCommunicationNode) {
            return new CommunicationNodeDG(diagramHandle, gmNodeModel);
        }
        return null;
    }

    @objid ("7caaf8b5-ba52-4a23-801f-147dd7e4d961")
    private IDiagramLink getDeploymentLink(final DiagramHandle diagramHandle, final IGmLink gmLink) {
        // GmManifestation
        if (gmLink instanceof GmManifestation) {
            return new ManifestationDG(diagramHandle, gmLink);
        }
        return null;
    }

    @objid ("38b1bdac-e317-4e2d-a483-700852283135")
    private IDiagramNode getDeploymentNode(final DiagramHandle diagramHandle, final GmNodeModel gmNodeModel) {
        // GmDeploymentDiagram
        if (gmNodeModel instanceof GmDeploymentDiagram) {
            return new DeploymentDiagramDG(diagramHandle, gmNodeModel);
        }
        
        // GmArtifact
        if (gmNodeModel instanceof GmArtifact) {
            return new ArtifactDG(diagramHandle, gmNodeModel);
        }
        
        // GmNode
        if (gmNodeModel instanceof GmNode) {
            return new NodeDG(diagramHandle, gmNodeModel);
        }
        return null;
    }

    @objid ("3b77ae5c-74ca-4e69-9a30-e1150245bcc3")
    private IDiagramNode getObjectNode(final DiagramHandle diagramHandle, final GmNodeModel gmNodeModel) {
        // GmCommunicationDiagram
        if (gmNodeModel instanceof GmObjectDiagram) {
            return new ObjectDiagramDG(diagramHandle, gmNodeModel);
        }
        return null;
    }

    @objid ("dbd47700-fb34-4807-91cc-57a97ff7286e")
    private IDiagramLink getSequenceLink(final DiagramHandle diagramHandle, final IGmLink gmLinkModel) {
        // GmMessage
        if (gmLinkModel instanceof GmMessage) {
            return new MessageDG(diagramHandle, gmLinkModel);
        }
        return null;
    }

    @objid ("234916cf-8767-484b-942f-7b7b98886170")
    private IDiagramNode getSequenceNode(final DiagramHandle diagramHandle, final GmNodeModel gmNodeModel) {
        // GmLifeline
        if (gmNodeModel instanceof GmLifeline) {
            return new LifelineDG(diagramHandle, gmNodeModel);
        }
        
        // GmSequenceDiagram
        if (gmNodeModel instanceof GmSequenceDiagram) {
            return new SequenceDiagramDG(diagramHandle, gmNodeModel);
        }
        
        // GmExecutionOccurenceSpecification
        if (gmNodeModel instanceof GmExecutionOccurenceSpecification) {
            return new ExecutionOccurenceSpecificationDG(diagramHandle, gmNodeModel);
        }
        
        // GmExecutionSpecification
        if (gmNodeModel instanceof GmExecutionSpecification) {
            return new ExecutionSpecificationDG(diagramHandle, gmNodeModel);
        }
        
        // GmInteractionUse
        if (gmNodeModel instanceof GmInteractionUse) {
            return new InteractionUseDG(diagramHandle, gmNodeModel);
        }
        
        // GmGate
        if (gmNodeModel instanceof GmGate) {
            return new GateDG(diagramHandle, gmNodeModel);
        }
        
        // GmCombinedFragment
        if (gmNodeModel instanceof GmCombinedFragment) {
            return new CombinedFragmentDG(diagramHandle, gmNodeModel);
        }
        
        // GmInteractionOperand
        if (gmNodeModel instanceof GmInteractionOperand) {
            return new InteractionOperandDG(diagramHandle, gmNodeModel);
        }
        
        // GmStateInvariant
        if (gmNodeModel instanceof GmStateInvariant) {
            return new StateInvariantDG(diagramHandle, gmNodeModel);
        }
        return null;
    }

    @objid ("a326033c-0d99-4843-80f8-d2d3ffbb44d1")
    private IDiagramLink getStateLink(final DiagramHandle diagramHandle, final IGmLink gmLinkModel) {
        // GmTransition
        if (gmLinkModel instanceof GmTransition) {
            return new TransitionDG(diagramHandle, gmLinkModel);
        }
        return null;
    }

    @objid ("a2f32673-2bb0-4210-9424-80217acb087d")
    private IDiagramNode getStateNode(final DiagramHandle diagramHandle, final GmNodeModel gmNodeModel) {
        // GmChoice
        if (gmNodeModel instanceof GmChoice) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmConnectionPoint
        if (gmNodeModel instanceof GmConnectionPoint) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        
        }
        
        // GmDeepHistory
        if (gmNodeModel instanceof GmDeepHistory) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmEntry
        if (gmNodeModel instanceof GmEntry) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmExitPoint
        if (gmNodeModel instanceof GmExitPoint) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmFinalState
        if (gmNodeModel instanceof GmFinalState) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmForkState
        if (gmNodeModel instanceof GmForkState) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmInitialState
        if (gmNodeModel instanceof GmInitialState) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmInternalTransition
        if (gmNodeModel instanceof GmInternalTransition) {
            return new LeafNodeDG(diagramHandle, gmNodeModel);
        }
        
        // GmJoin
        if (gmNodeModel instanceof GmJoin) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmJunction
        if (gmNodeModel instanceof GmJunction) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmRegion
        if (gmNodeModel instanceof GmRegion) {
            return new RegionDG(diagramHandle, gmNodeModel);
        }
        
        // GmShallowHistory
        if (gmNodeModel instanceof GmShallowHistory) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        
        // GmState
        if (gmNodeModel instanceof GmState) {
            return new StateDG(diagramHandle, gmNodeModel);
        }
        
        // GmStateDiagram
        if (gmNodeModel instanceof GmStateDiagram) {
            return new StateDiagramDG(diagramHandle, gmNodeModel);
        }
        
        // GmTerminal
        if (gmNodeModel instanceof GmTerminal) {
            return new LeafPortContainerDG(diagramHandle, gmNodeModel);
        }
        return null;
    }

    @objid ("5cf86aa0-d282-48b8-a5e2-455b6afff1b2")
    private IDiagramLink getStatikLink(final DiagramHandle diagramHandle, final IGmLink gmNodeModel) {
        // GmAssociation
        if (gmNodeModel instanceof GmAssociation) {
            return new AssociationDG(diagramHandle, gmNodeModel);
        }
        
        // GmBindingLink
        if (gmNodeModel instanceof GmBindingLink) {
            return new BindingLinkDG(diagramHandle, gmNodeModel);
        }
        
        // GmClassAssociation
        if (gmNodeModel instanceof GmClassAssociationLink) {
            return new ClassAssociationDG(diagramHandle, gmNodeModel);
        }
        
        // GmConnector
        if (gmNodeModel instanceof GmConnectorLink) {
            return new ConnectorDG(diagramHandle, gmNodeModel);
        }
        
        // GmElementImport
        if (gmNodeModel instanceof GmElementImport) {
            return new ElementImportDG(diagramHandle, gmNodeModel);
        }
        
        // GmGeneralization
        if (gmNodeModel instanceof GmGeneralization) {
            return new GeneralizationDG(diagramHandle, gmNodeModel);
        }
        
        // GmInformationFlowLink
        if (gmNodeModel instanceof GmInformationFlowLink) {
            return new InformationFlowDG(diagramHandle, gmNodeModel);
        }
        
        // GmInstanceLink
        if (gmNodeModel instanceof GmInstanceLink) {
            return new LinkDG(diagramHandle, gmNodeModel);
        }
        
        // GmInterfaceRealization
        if (gmNodeModel instanceof GmInterfaceRealization) {
            return new InterfaceRealizationDG(diagramHandle, gmNodeModel);
        }
        
        // GmPackageImport
        if (gmNodeModel instanceof GmPackageImport) {
            return new PackageImportDG(diagramHandle, gmNodeModel);
        }
        
        // GmPackageMerge
        if (gmNodeModel instanceof GmPackageMerge) {
            return new PackageMergeDG(diagramHandle, gmNodeModel);
        }
        
        // GmProvidedInterface
        if (gmNodeModel instanceof GmProvidedInterfaceLink) {
            return new ProvidedInterfaceDG(diagramHandle, gmNodeModel);
        }
        
        // GmRaisedException
        if (gmNodeModel instanceof GmRaisedException) {
            return new RaisedExceptionDG(diagramHandle, gmNodeModel);
        }
        
        // GmRequiredInterface
        if (gmNodeModel instanceof GmRequiredInterfaceLink) {
            return new RequiredInterfaceDG(diagramHandle, gmNodeModel);
        }
        
        // GmTemplateBinding
        if (gmNodeModel instanceof GmTemplateBinding) {
            return new TemplateBindingDG(diagramHandle, gmNodeModel);
        }
        return null;
    }

    @objid ("434c228f-fa63-4d38-9311-a7da3bda56ad")
    private IDiagramNode getStatikNode(final DiagramHandle diagramHandle, final GmNodeModel gmNodeModel) {
        // GmActivity
        if (gmNodeModel instanceof GmActivity) {
            return new ActivityDG(diagramHandle, gmNodeModel);
        }
        
        // GmAttribute
        if (gmNodeModel instanceof GmAttribute) {
            return new LeafNodeDG(diagramHandle, gmNodeModel);
        }
        
        // GmBindingLabel
        if (gmNodeModel instanceof GmBindingLabel) {
            return new LabelDG(diagramHandle, gmNodeModel);
        }
        
        // GmClass
        if (gmNodeModel instanceof GmClass) {
            return new ClassDG(diagramHandle, gmNodeModel);
        }
        
        // GmCollaboration
        if (gmNodeModel instanceof GmCollaboration) {
            return new CollaborationDG(diagramHandle, gmNodeModel);
        }
        
        // GmCollaborationUse
        if (gmNodeModel instanceof GmCollaborationUse) {
            return new CollaborationUseDG(diagramHandle, gmNodeModel);
        }
        
        if (gmNodeModel instanceof GmCommunicationInteraction) {
            return new CommunicationInteractionDG(diagramHandle, gmNodeModel);
        }
        
        // GmComponent
        if (gmNodeModel instanceof GmComponent) {
            return new ComponentDG(diagramHandle, gmNodeModel);
        }
        
        // GmDataType
        if (gmNodeModel instanceof GmDataType) {
            return new DataTypeDG(diagramHandle, gmNodeModel);
        }
        
        // GmEnum
        if (gmNodeModel instanceof GmEnum) {
            return new EnumerationDG(diagramHandle, gmNodeModel);
        }
        
        // GmEnumLitteral
        if (gmNodeModel instanceof GmEnumLitteral) {
            return new LeafNodeDG(diagramHandle, gmNodeModel);
        }
        
        // GmInformationItem
        if (gmNodeModel instanceof GmInformationItem) {
            return new LeafNodeDG(diagramHandle, gmNodeModel);
        }
        
        // GmInstance
        if (gmNodeModel instanceof GmInstance) {
            return new InstanceDG(diagramHandle, gmNodeModel);
        }
        
        if (gmNodeModel instanceof GmInteraction) {
            return new InteractionDG(diagramHandle, gmNodeModel);
        }
        
        // GmInterface
        if (gmNodeModel instanceof GmInterface) {
            return new InterfaceDG(diagramHandle, gmNodeModel);
        }
        
        // TODO GmModule
        // if (gmNodeModel instanceof GmModule) {
        // return new CollaborationUseDG(diagramHandle, gmNodeModel);
        // }
        
        // GmOperation
        if (gmNodeModel instanceof GmOperation) {
            return new LeafNodeDG(diagramHandle, gmNodeModel);
        }
        
        // GmPort
        if (gmNodeModel instanceof GmPort) {
            return new PortDG(diagramHandle, gmNodeModel);
        }
        
        // TODO GmProfile
        // if (gmNodeModel instanceof GmProfile) {
        // return new ProfileDG(diagramHandle, gmNodeModel);
        // }
        
        // GmSignal
        if (gmNodeModel instanceof GmSignal) {
            return new SignalDG(diagramHandle, gmNodeModel);
        }
        
        // GmSlot
        if (gmNodeModel instanceof GmSlot) {
            return new LeafNodeDG(diagramHandle, gmNodeModel);
        }
        
        // State Machine
        if (gmNodeModel instanceof GmStateMachine) {
            return new StateMachineDG(diagramHandle, gmNodeModel);
        }
        
        if (gmNodeModel instanceof GmBpmnProcess) {
            return new BpmnProcessDG(diagramHandle, gmNodeModel);
        }
        
        if (gmNodeModel instanceof GmBpmnBehavior) {
            return new BpmnBehaviorDG(diagramHandle, gmNodeModel);
        }
        
        if (gmNodeModel instanceof GmBpmnCollaboration) {
            return new BpmnCollaborationDG(diagramHandle, gmNodeModel);
        }
        
        if (gmNodeModel instanceof GmBpmnSharedDefinitions) {
            return new BpmnSharedDefinitionsDG(diagramHandle, gmNodeModel);
        }
        
        // GmStaticDiagram
        if (gmNodeModel instanceof GmStaticDiagram) {
            return new StaticDiagramDG(diagramHandle, gmNodeModel);
        }
        
        // GmPackage
        if (gmNodeModel instanceof GmPackage) {
            return new PackageDG(diagramHandle, gmNodeModel);
        }
        return null;
    }

    @objid ("9b38c263-32bd-426b-a0d1-2399691d5208")
    private IDiagramLink getUseCaseLink(final DiagramHandle diagramHandle, final IGmLink gmLinkModel) {
        // GmCommunicationChannel
        if (gmLinkModel instanceof GmCommunicationChannel) {
            return new AssociationDG(diagramHandle, gmLinkModel);
        }
        
        // GmUseCaseDependency
        if (gmLinkModel instanceof GmUseCaseDependency) {
            return new UseCaseDependencyDG(diagramHandle, gmLinkModel);
        }
        return null;
    }

    @objid ("17f952c8-17d8-4cb5-8f78-0ed9252bcea3")
    private IDiagramNode getUseCaseNode(final DiagramHandle diagramHandle, final GmNodeModel gmNodeModel) {
        // GmActor
        if (gmNodeModel instanceof GmActor) {
            return new ActorDG(diagramHandle, gmNodeModel);
        }
        
        // GmExtensionPoint
        if (gmNodeModel instanceof GmExtensionPoint) {
            return new LeafNodeDG(diagramHandle, gmNodeModel);
        
        }
        
        // GmUseCase
        if (gmNodeModel instanceof GmUseCase) {
            return new UseCaseDG(diagramHandle, gmNodeModel);
        }
        
        // GmUseCaseDiagram
        if (gmNodeModel instanceof GmUseCaseDiagram) {
            return new UseCaseDiagramDG(diagramHandle, gmNodeModel);
        }
        
        // GmSystem
        if (gmNodeModel instanceof GmSystem) {
            return new SystemDG(diagramHandle, gmNodeModel);
        }
        return null;
    }

}
