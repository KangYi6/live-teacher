/// <reference types="vexflow" />
import { EngravingRules } from "./EngravingRules";
import { VexFlowMeasure } from "./VexFlow/VexFlowMeasure";
import { SkyBottomLineCalculationResult } from "./SkyBottomLineCalculationResult";
import { ISkyBottomLineBatchCalculatorBackendPartialTableConfiguration, ISkyBottomLineBatchCalculatorBackendTableConfiguration, SkyBottomLineBatchCalculatorBackend } from "./SkyBottomLineBatchCalculatorBackend";
/**
 * This class calculates the skylines and the bottom lines by iterating over pixels retrieved via
 * CanvasRenderingContext2D.getImageData().
 */
export declare class PlainSkyBottomLineBatchCalculatorBackend extends SkyBottomLineBatchCalculatorBackend {
    constructor(rules: EngravingRules, measures: VexFlowMeasure[]);
    protected getPreferredRenderingConfiguration(maxWidth: number, elementHeight: number): ISkyBottomLineBatchCalculatorBackendPartialTableConfiguration;
    protected onInitialize(tableConfiguration: ISkyBottomLineBatchCalculatorBackendTableConfiguration): void;
    protected calculateFromCanvas(canvas: HTMLCanvasElement, vexFlowContext: Vex.Flow.CanvasContext, measures: VexFlowMeasure[], samplingUnit: number, tableConfiguration: ISkyBottomLineBatchCalculatorBackendTableConfiguration): SkyBottomLineCalculationResult[];
}
