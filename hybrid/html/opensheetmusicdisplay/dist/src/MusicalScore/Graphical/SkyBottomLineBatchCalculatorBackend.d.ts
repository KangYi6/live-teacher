/// <reference types="vexflow" />
import { EngravingRules } from "./EngravingRules";
import { SkyBottomLineCalculationResult } from "./SkyBottomLineCalculationResult";
import { VexFlowMeasure } from "./VexFlow/VexFlowMeasure";
/**
 * SkyBottomLineBatchCalculatorBackend renders measures in a borderless table.
 * This interface contains the configuration for the table returned by classes
 * implementing SkyBottomLineBatchCalculatorBackend. The height of a cell is
 * set to a fixed value by SkyBottomLineBatchCalculatorBackend.
 */
export interface ISkyBottomLineBatchCalculatorBackendPartialTableConfiguration {
    /** The width of each cell */
    elementWidth: number;
    /** The number of cell in a row */
    numColumns: number;
    /** The number of cell in a column */
    numRows: number;
}
/**
 * This interface contains the complete configuration for the table rendered by
 * SkyBottomLineBatchCalculatorBackend,
 */
export interface ISkyBottomLineBatchCalculatorBackendTableConfiguration extends ISkyBottomLineBatchCalculatorBackendPartialTableConfiguration {
    /** The height of each cell determined by SkyBottomLineBatchCalculatorBackend */
    elementHeight: number;
}
/**
 * This class calculates the sky lines and the bottom lines for multiple stafflines.
 */
export declare abstract class SkyBottomLineBatchCalculatorBackend {
    /** The canvas where the measures are to be drawn in */
    private readonly canvas;
    /** The measures to draw */
    private readonly measures;
    /** The width of the widest measure */
    private readonly maxWidth;
    /** The samplingUnit from the EngravingRules */
    private readonly samplingUnit;
    /**
     * The default height used by CanvasVexFlowBackend. Update this value when the
     * default height value of CanvasVexFlowBackend.initializeHeadless is updated.
     * This value is used as a height of each cell in the table rendered by this class.
     */
    private readonly elementHeight;
    /**
     * The table configuration returned by getPreferredRenderingConfiguration. This value
     * is set after initialize() returns.
     */
    private tableConfiguration;
    constructor(rules: EngravingRules, measures: VexFlowMeasure[]);
    /**
     * This method returns the configuration for the table where the measures are to be rendered.
     * @param maxWidth the width of the widest measure
     * @param elementHeight the height of each cell
     */
    protected abstract getPreferredRenderingConfiguration(maxWidth: number, elementHeight: number): ISkyBottomLineBatchCalculatorBackendPartialTableConfiguration;
    /**
     * This method allocates resources required by the implementation class.
     * @param tableConfiguration the table configuration returned by getPreferredRenderingConfiguration
     */
    protected abstract onInitialize(tableConfiguration: ISkyBottomLineBatchCalculatorBackendTableConfiguration): void;
    /**
     * This method allocates required resources for the calculation.
     */
    initialize(): SkyBottomLineBatchCalculatorBackend;
    /**
     * This method calculates the skylines and the bottom lines for the measures rendered in the given canvas.
     * @param canvas the canvas where the measures are rendered
     * @param context the drawing context of canvas
     * @param measures the rendered measures
     * @param tableConfiguration the table configuration returned by getPreferredRenderingConfiguration
     */
    protected abstract calculateFromCanvas(canvas: HTMLCanvasElement, context: Vex.Flow.CanvasContext, measures: VexFlowMeasure[], samplingUnit: number, tableConfiguration: ISkyBottomLineBatchCalculatorBackendTableConfiguration): SkyBottomLineCalculationResult[];
    /**
     * This method calculates the skylines and the bottom lines for the measures passed to the constructor.
     */
    calculateLines(): SkyBottomLineCalculationResult[];
}
