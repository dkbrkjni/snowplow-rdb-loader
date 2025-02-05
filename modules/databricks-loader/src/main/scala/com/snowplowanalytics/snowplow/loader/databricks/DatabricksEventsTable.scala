package com.snowplowanalytics.snowplow.loader.databricks

object DatabricksEventsTable {
  def statement(tableName: String): String =
    s"""
      |CREATE TABLE IF NOT EXISTS $tableName (
      |  app_id                      VARCHAR(255),
      |  platform                    VARCHAR(255),
      |  etl_tstamp                  TIMESTAMP,
      |  collector_tstamp            TIMESTAMP       NOT NULL,
      |  dvce_created_tstamp         TIMESTAMP,
      |  event                       VARCHAR(128),
      |  event_id                    VARCHAR(36)     NOT NULL,
      |  txn_id                      INTEGER,
      |  name_tracker                VARCHAR(128),
      |  v_tracker                   VARCHAR(100),
      |  v_collector                 VARCHAR(100)    NOT NULL,
      |  v_etl                       VARCHAR(100)    NOT NULL,
      |  user_id                     VARCHAR(255),
      |  user_ipaddress              VARCHAR(128),
      |  user_fingerprint            VARCHAR(128),
      |  domain_userid               VARCHAR(128),
      |  domain_sessionidx           SMALLINT,
      |  network_userid              VARCHAR(128),
      |  geo_country                 VARCHAR(2),
      |  geo_region                  VARCHAR(3),
      |  geo_city                    VARCHAR(75),
      |  geo_zipcode                 VARCHAR(15),
      |  geo_latitude                DOUBLE,
      |  geo_longitude               DOUBLE,
      |  geo_region_name             VARCHAR(100),
      |  ip_isp                      VARCHAR(100),
      |  ip_organization             VARCHAR(128),
      |  ip_domain                   VARCHAR(128),
      |  ip_netspeed                 VARCHAR(100),
      |  page_url                    VARCHAR(4096),
      |  page_title                  VARCHAR(2000),
      |  page_referrer               VARCHAR(4096),
      |  page_urlscheme              VARCHAR(16),
      |  page_urlhost                VARCHAR(255),
      |  page_urlport                INTEGER,
      |  page_urlpath                VARCHAR(3000),
      |  page_urlquery               VARCHAR(6000),
      |  page_urlfragment            VARCHAR(3000),
      |  refr_urlscheme              VARCHAR(16),
      |  refr_urlhost                VARCHAR(255),
      |  refr_urlport                INTEGER,
      |  refr_urlpath                VARCHAR(6000),
      |  refr_urlquery               VARCHAR(6000),
      |  refr_urlfragment            VARCHAR(3000),
      |  refr_medium                 VARCHAR(25),
      |  refr_source                 VARCHAR(50),
      |  refr_term                   VARCHAR(255),
      |  mkt_medium                  VARCHAR(255),
      |  mkt_source                  VARCHAR(255),
      |  mkt_term                    VARCHAR(255),
      |  mkt_content                 VARCHAR(500),
      |  mkt_campaign                VARCHAR(255),
      |  se_category                 VARCHAR(1000),
      |  se_action                   VARCHAR(1000),
      |  se_label                    VARCHAR(4096),
      |  se_property                 VARCHAR(1000),
      |  se_value                    DOUBLE,
      |  tr_orderid                  VARCHAR(255),
      |  tr_affiliation              VARCHAR(255),
      |  tr_total                    DECIMAL(18,2),
      |  tr_tax                      DECIMAL(18,2),
      |  tr_shipping                 DECIMAL(18,2),
      |  tr_city                     VARCHAR(255),
      |  tr_state                    VARCHAR(255),
      |  tr_country                  VARCHAR(255),
      |  ti_orderid                  VARCHAR(255),
      |  ti_sku                      VARCHAR(255),
      |  ti_name                     VARCHAR(255),
      |  ti_category                 VARCHAR(255),
      |  ti_price                    DECIMAL(18,2),
      |  ti_quantity                 INTEGER,
      |  pp_xoffset_min              INTEGER,
      |  pp_xoffset_max              INTEGER,
      |  pp_yoffset_min              INTEGER,
      |  pp_yoffset_max              INTEGER,
      |  useragent                   VARCHAR(1000),
      |  br_name                     VARCHAR(50),
      |  br_family                   VARCHAR(50),
      |  br_version                  VARCHAR(50),
      |  br_type                     VARCHAR(50),
      |  br_renderengine             VARCHAR(50),
      |  br_lang                     VARCHAR(255),
      |  br_features_pdf             BOOLEAN,
      |  br_features_flash           BOOLEAN,
      |  br_features_java            BOOLEAN,
      |  br_features_director        BOOLEAN,
      |  br_features_quicktime       BOOLEAN,
      |  br_features_realplayer      BOOLEAN,
      |  br_features_windowsmedia    BOOLEAN,
      |  br_features_gears           BOOLEAN,
      |  br_features_silverlight     BOOLEAN,
      |  br_cookies                  BOOLEAN,
      |  br_colordepth               VARCHAR(12),
      |  br_viewwidth                INTEGER,
      |  br_viewheight               INTEGER,
      |  os_name                     VARCHAR(50),
      |  os_family                   VARCHAR(50),
      |  os_manufacturer             VARCHAR(50),
      |  os_timezone                 VARCHAR(255),
      |  dvce_type                   VARCHAR(50),
      |  dvce_ismobile               BOOLEAN,
      |  dvce_screenwidth            INTEGER,
      |  dvce_screenheight           INTEGER,
      |  doc_charset                 VARCHAR(128),
      |  doc_width                   INTEGER,
      |  doc_height                  INTEGER,
      |  tr_currency                 VARCHAR(3),
      |  tr_total_base               DECIMAL(18, 2),
      |  tr_tax_base                 DECIMAL(18, 2),
      |  tr_shipping_base            DECIMAL(18, 2),
      |  ti_currency                 VARCHAR(3),
      |  ti_price_base               DECIMAL(18, 2),
      |  base_currency               VARCHAR(3),
      |  geo_timezone                VARCHAR(64),
      |  mkt_clickid                 VARCHAR(128),
      |  mkt_network                 VARCHAR(64),
      |  etl_tags                    VARCHAR(500),
      |  dvce_sent_tstamp            TIMESTAMP,
      |  refr_domain_userid          VARCHAR(128),
      |  refr_dvce_tstamp            TIMESTAMP,
      |  domain_sessionid            VARCHAR(128),
      |  derived_tstamp              TIMESTAMP,
      |  event_vendor                VARCHAR(1000),
      |  event_name                  VARCHAR(1000),
      |  event_format                VARCHAR(128),
      |  event_version               VARCHAR(128),
      |  event_fingerprint           VARCHAR(128),
      |  true_tstamp                 TIMESTAMP,
      |  collector_tstamp_date       DATE GENERATED ALWAYS AS (DATE(collector_tstamp))
      |)
      |PARTITIONED BY (collector_tstamp_date, event_name);
      |""".stripMargin
}
