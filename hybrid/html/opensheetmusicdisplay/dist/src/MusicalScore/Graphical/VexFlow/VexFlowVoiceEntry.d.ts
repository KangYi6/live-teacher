import Vex from "vexflow";
import VF = Vex.Flow;
import { VoiceEntry } from "../../VoiceData/VoiceEntry";
import { GraphicalVoiceEntry } from "../GraphicalVoiceEntry";
import { GraphicalStaffEntry } from "../GraphicalStaffEntry";
export declare class VexFlowVoiceEntry extends GraphicalVoiceEntry {
    private mVexFlowStaveNote;
    constructor(parentVoiceEntry: VoiceEntry, parentStaffEntry: GraphicalStaffEntry);
    applyBordersFromVexflow(): void;
    set vfStaveNote(value: VF.StemmableNote);
    get vfStaveNote(): VF.StemmableNote;
    /** (Re-)color notes and stems by setting their Vexflow styles.
     * Could be made redundant by a Vexflow PR, but Vexflow needs more solid and permanent color methods/variables for that
     * See VexFlowConverter.StaveNote()
     */
    color(): void;
}
