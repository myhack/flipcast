package com.flipcast.push.common

import com.flipcast.push.model.{SidelinedMessage, PushHistoryData, DeviceData}
import java.util.Date

/**
 * Trait for enabling pluggable device data providers
 *
 * @author Phaneesh Nagaraja
 */
trait DeviceDataSource {

  def init()

  def register(config: String, deviceData: String, filter: Map[String, Any]) : DeviceData

  def unregister(config: String, filter: Map[String, Any]) : Boolean

  def count(config: String, filter : Map[String, Any]) : Long

  def get(config: String, filter : Map[String, Any]) : Option[DeviceData]

  def list(config: String, filter : Map[String, Any], pageSize: Int, pageNo: Int) : List[DeviceData]

  def listAll(config: String, pageSize: Int, pageNo: Int) : List[DeviceData]

  def doHouseKeeping(config: String, deviceIdentifier: String) : Boolean

  def autoUpdateDeviceId(config: String, deviceIdentifier: String, newDeviceIdentifier: String) : Boolean

  def recordHistory(config: String, key: String, message: String) : Boolean

  def pushHistory(config: String, from: Date) : PushHistoryData

  def sidelineMessage(message: SidelinedMessage) : Boolean

  def listSidelineMessage(config: String,filter : Map[String, Any], pageSize: Int, pageNo: Int) : List[SidelinedMessage]

}
