package entities;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * Created by michal on 31.12.2016.
 */
//Entity
public class ProductionEntity {

    private long productionId;
    private LineEntity line;
    private FormEntity form;
    private LocalDateTime start;
    private Duration duration;
    private Duration startAndWormUp;
    private Duration endAndCleaning;
    private double speed;
    private long output;
    private double utilization;
    private String color;
    private String note;

    public ProductionEntity() {
    }

    public long getProductionId() {
        return this.productionId;
    }

    public LineEntity getLine() {
        return this.line;
    }

    public FormEntity getForm() {
        return this.form;
    }

    public LocalDateTime getStart() {
        return this.start;
    }

    public Duration getDuration() {
        return this.duration;
    }

    public Duration getStartAndWormUp() {
        return this.startAndWormUp;
    }

    public Duration getEndAndCleaning() {
        return this.endAndCleaning;
    }

    public double getSpeed() {
        return this.speed;
    }

    public long getOutput() {
        return this.output;
    }

    public double getUtilization() {
        return this.utilization;
    }

    public String getColor() {
        return this.color;
    }

    public String getNote() {
        return this.note;
    }

    public void setProductionId(long productionId) {
        this.productionId = productionId;
    }

    public void setLine(LineEntity line) {
        this.line = line;
    }

    public void setForm(FormEntity form) {
        this.form = form;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public void setStartAndWormUp(Duration startAndWormUp) {
        this.startAndWormUp = startAndWormUp;
    }

    public void setEndAndCleaning(Duration endAndCleaning) {
        this.endAndCleaning = endAndCleaning;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setOutput(long output) {
        this.output = output;
    }

    public void setUtilization(double utilization) {
        this.utilization = utilization;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof ProductionEntity)) return false;
        final ProductionEntity other = (ProductionEntity) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getProductionId() != other.getProductionId()) return false;
        final Object this$line = this.getLine();
        final Object other$line = other.getLine();
        if (this$line == null ? other$line != null : !this$line.equals(other$line)) return false;
        final Object this$form = this.getForm();
        final Object other$form = other.getForm();
        if (this$form == null ? other$form != null : !this$form.equals(other$form)) return false;
        final Object this$start = this.getStart();
        final Object other$start = other.getStart();
        if (this$start == null ? other$start != null : !this$start.equals(other$start)) return false;
        final Object this$duration = this.getDuration();
        final Object other$duration = other.getDuration();
        if (this$duration == null ? other$duration != null : !this$duration.equals(other$duration)) return false;
        final Object this$startAndWormUp = this.getStartAndWormUp();
        final Object other$startAndWormUp = other.getStartAndWormUp();
        if (this$startAndWormUp == null ? other$startAndWormUp != null : !this$startAndWormUp.equals(other$startAndWormUp))
            return false;
        final Object this$endAndCleaning = this.getEndAndCleaning();
        final Object other$endAndCleaning = other.getEndAndCleaning();
        if (this$endAndCleaning == null ? other$endAndCleaning != null : !this$endAndCleaning.equals(other$endAndCleaning))
            return false;
        if (Double.compare(this.getSpeed(), other.getSpeed()) != 0) return false;
        if (this.getOutput() != other.getOutput()) return false;
        if (Double.compare(this.getUtilization(), other.getUtilization()) != 0) return false;
        final Object this$color = this.getColor();
        final Object other$color = other.getColor();
        if (this$color == null ? other$color != null : !this$color.equals(other$color)) return false;
        final Object this$note = this.getNote();
        final Object other$note = other.getNote();
        if (this$note == null ? other$note != null : !this$note.equals(other$note)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $productionId = this.getProductionId();
        result = result * PRIME + (int) ($productionId >>> 32 ^ $productionId);
        final Object $line = this.getLine();
        result = result * PRIME + ($line == null ? 43 : $line.hashCode());
        final Object $form = this.getForm();
        result = result * PRIME + ($form == null ? 43 : $form.hashCode());
        final Object $start = this.getStart();
        result = result * PRIME + ($start == null ? 43 : $start.hashCode());
        final Object $duration = this.getDuration();
        result = result * PRIME + ($duration == null ? 43 : $duration.hashCode());
        final Object $startAndWormUp = this.getStartAndWormUp();
        result = result * PRIME + ($startAndWormUp == null ? 43 : $startAndWormUp.hashCode());
        final Object $endAndCleaning = this.getEndAndCleaning();
        result = result * PRIME + ($endAndCleaning == null ? 43 : $endAndCleaning.hashCode());
        final long $speed = Double.doubleToLongBits(this.getSpeed());
        result = result * PRIME + (int) ($speed >>> 32 ^ $speed);
        final long $output = this.getOutput();
        result = result * PRIME + (int) ($output >>> 32 ^ $output);
        final long $utilization = Double.doubleToLongBits(this.getUtilization());
        result = result * PRIME + (int) ($utilization >>> 32 ^ $utilization);
        final Object $color = this.getColor();
        result = result * PRIME + ($color == null ? 43 : $color.hashCode());
        final Object $note = this.getNote();
        result = result * PRIME + ($note == null ? 43 : $note.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof ProductionEntity;
    }

    public String toString() {
        return "entities.ProductionEntity(productionId=" + this.getProductionId() + ", line=" + this.getLine() + ", form=" + this.getForm() + ", start=" + this.getStart() + ", duration=" + this.getDuration() + ", startAndWormUp=" + this.getStartAndWormUp() + ", endAndCleaning=" + this.getEndAndCleaning() + ", speed=" + this.getSpeed() + ", output=" + this.getOutput() + ", utilization=" + this.getUtilization() + ", color=" + this.getColor() + ", note=" + this.getNote() + ")";
    }
}
